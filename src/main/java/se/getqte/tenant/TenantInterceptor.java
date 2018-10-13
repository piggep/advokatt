package se.getqte.tenant;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import se.getqte.auth0.Auth0ManagmentAPI;
import se.getqte.configuration.IAuthenticationFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class TenantInterceptor extends HandlerInterceptorAdapter {

  private static final String TENANT_HEADER = "X-TenantID";

  @Autowired
  private IAuthenticationFacade authenticationFacade;

  @Autowired
  private Auth0ManagmentAPI auth0;

  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

    boolean tenantSet = false;
    Map<String, Object> appMetadata =  auth0.getUser(authenticationFacade.getAuthentication().getName()).getAppMetadata();
    String tenant = appMetadata != null ? (String) appMetadata.getOrDefault("tenant", "") : "";
    if(tenant.equals("")){
      res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      res.setContentType(MediaType  .APPLICATION_JSON_VALUE);
      res.getWriter().write("{\"error\": \"No tenant supplied\"}");
      res.getWriter().flush();
    } else {
      TenantContext.setCurrentTenant(tenant);
      tenantSet = true;
    }

    return tenantSet;
  }

  @Override
  public void postHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
          throws Exception {
    TenantContext.clear();
  }
}
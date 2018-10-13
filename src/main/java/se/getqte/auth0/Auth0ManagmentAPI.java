package se.getqte.auth0;

import com.auth0.client.auth.AuthAPI;
import com.auth0.client.mgmt.ManagementAPI;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.auth.TokenHolder;
import com.auth0.json.mgmt.users.User;
import com.auth0.net.AuthRequest;
import com.auth0.net.Request;
import org.springframework.stereotype.Service;

@Service
public class Auth0ManagmentAPI {
    private AuthAPI authAPI;
    private ManagementAPI mgmt;

    public Auth0ManagmentAPI(){
        authAPI = new AuthAPI("qte.eu.auth0.com", "oWr2O3gfeHi3Gf6J3UH4ZE7fB4JKDsyf", "a7fLv509euDx_5cky-suMDgU4s0Q_fykwqMTCxNdXnGSmFUhly5qIsQaeQZGYxVF");
        AuthRequest authRequest = authAPI.requestToken("https://qte.eu.auth0.com/api/v2/");
        TokenHolder holder = null;
        try {
            holder = authRequest.execute();
            mgmt = new ManagementAPI("qte.eu.auth0.com", holder.getAccessToken());
        } catch (Auth0Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(String userId) throws Auth0Exception {
        Request<User> user = mgmt.users().get(userId, null);
        return user.execute();
    }
}

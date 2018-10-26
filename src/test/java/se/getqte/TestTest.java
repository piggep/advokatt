package se.getqte;

import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.getqte.model.repository.ClientRepository;
import se.getqte.tenant.TenantContext;
import se.getqte.tenant.hibernate.MultiTenantConnectionProviderImpl;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTest {

    @Autowired
    ClientRepository clientRepository;
    Logger logger = Logger.getLogger(TestTest.class.getName());


    @Test
    public void whenFindByName_thenReturnEmployee() {

        logger.warning("sad");
        logger.warning(clientRepository.findAll().size() + "");

    }
}

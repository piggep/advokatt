package se.getqte;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import se.getqte.model.repository.ClientRepository;
import java.util.logging.Logger;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class TestTest {

    @Autowired
    ClientRepository clientRepository;

    Logger logger = Logger.getLogger(TestTest.class.getName());

    @Autowired
    private ClientRepository repository;


    @Test
    public void whenFindByName_thenReturnEmployee() throws Exception {
        logger.warning(clientRepository.findAll().size() + "");

        throw new Exception("asd");

    }
}

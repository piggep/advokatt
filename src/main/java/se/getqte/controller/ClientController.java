package se.getqte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.getqte.model.Client;
import se.getqte.model.repository.ClientRepository;


/** Simple controller to illustrate templates. */
@RestController
@RequestMapping(value = "/client")
public class ClientController extends ControllerCRUD {

  @Autowired
  public ClientController(ClientRepository clientRepository){
    super.setRepository(clientRepository);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody public ResponseEntity<?> getClient(@PathVariable final Long id) {
    return super.getSpecific(id);
  }


  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody public ResponseEntity<?> saveClient(@RequestBody Client client) {
    return super.save(client);

  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody public ResponseEntity<?> getClients() {
    return super.getAll();
  }
}

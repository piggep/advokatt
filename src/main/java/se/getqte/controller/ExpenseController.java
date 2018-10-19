package se.getqte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.getqte.model.Client;
import se.getqte.model.repository.ErrandGroupRepository;
import se.getqte.model.repository.ExpenseRepository;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseController extends ControllerCRUD {


    @Autowired
    public ExpenseController(ExpenseRepository repository){
        super.setRepository(repository);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> get(@PathVariable final Long id) {
        return super.getSpecific(id);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody public ResponseEntity<?> save(@RequestBody Client client) {
        return super.save(client);

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody public ResponseEntity<?> getAll() {
        return super.getAll();
    }

}

package se.getqte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.getqte.model.Errand;
import se.getqte.model.repository.ClientRepository;
import se.getqte.model.repository.ErrandRepository;

@RestController
@RequestMapping(value = "/errandclient")
public class ErrandClientController {

    @Autowired
    ErrandRepository errandRepository;

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> findErrandsForClient(@PathVariable final Long id) {
        return ResponseEntity.ok(errandRepository.findAllByClient(clientRepository.findOne(id)));
    }
}

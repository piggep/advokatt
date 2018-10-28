package se.getqte.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import java.net.URI;
import java.util.logging.Logger;

public class ControllerCRUD {

    private JpaRepository<Object, Long> repository;
    private Logger logger = Logger.getLogger(ControllerCRUD.class.getName());
    protected void setRepository(JpaRepository rep){
        repository = rep;
    }

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }


    public ResponseEntity<?> getSpecific(Long id) {
        final Object obj = repository.findOne(id);
        if (obj  == null) {
            return ResponseEntity.notFound().build();
        }

        final Resource<Object> resource = new Resource<>(obj);

        return ResponseEntity.ok(resource);
    }


    public ResponseEntity<?> delete(Long id){
        repository.delete(id);
        logger.info("Successfully deleted entity with id = " + id);
        return ResponseEntity.ok().build();
    }


    public ResponseEntity<?> save(Object repo) {
        Object obj = repository.save(repo);
        logger.info("Successfully created new entity");
        return ResponseEntity.ok(repo);
    }

}

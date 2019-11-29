package org.sid.demo.web;

import org.sid.demo.dao.PersonneRepeository;
import org.sid.demo.entities.Personne;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class Controller {


    final private PersonneRepeository personneRepeository;

    public Controller(PersonneRepeository personneRepeository){
        this.personneRepeository=personneRepeository;
    }

    @GetMapping("personnes")
    public ResponseEntity<List<Personne>> getAll(){
        ResponseEntity<List<Personne>> responseEntity=new ResponseEntity<List<Personne>>( personneRepeository.findAll(), HttpStatus.OK);

        return responseEntity;
    }
}

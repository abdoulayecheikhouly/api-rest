package com.ly.api.testapi.service;

import com.ly.api.testapi.model.Personne;
import com.ly.api.testapi.repository.PersonneRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Data
@Service
public class PersonneService {

    @Autowired
    PersonneRepository personneRepository;

    public Optional<Personne> getPersID(@PathVariable("id") Long id){
        return  personneRepository.findById(id);
    }

    public Iterable <Personne> getPersonne(){
        return  personneRepository.findAll();
    }

    public Personne SavePersonne(@RequestBody Personne p){
        Personne personne= personneRepository.save(p);
        return personne;
    }

    public void DeletePer(@PathVariable("id") Long id){
       personneRepository.deleteById(id);
    }
}

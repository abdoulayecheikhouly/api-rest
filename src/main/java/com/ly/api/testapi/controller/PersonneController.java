package com.ly.api.testapi.controller;

import com.ly.api.testapi.model.Personne;
import com.ly.api.testapi.repository.PersonneRepository;
import com.ly.api.testapi.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController


public class PersonneController {

    @Autowired

    private PersonneService personneService;


    @GetMapping("/updateEmployee/{id}")
    public String updatePersonne(@PathVariable("id") Long id, Model model) {
        Optional<Personne> p = personneService.getPersID(id);
        model.addAttribute("personne", p);
        return "formUpdatePersonne";
    }
    @GetMapping("/")
    public String home(Model model){
     Iterable<Personne> getPersonne=personneService.getPersonne();

     model.addAttribute("personne",getPersonne);

        return "home";
    }
    @GetMapping("/createPersonne")
    public String createEmployee(Model model) {
        Personne p = new Personne();
        model.addAttribute("personne", p);
        return "formNewPersonne";
    }
    @PostMapping("/savePersonne")
    public ModelAndView saveEmployee(@ModelAttribute Personne p) {
        if(p.getId() != null) {
            // Employee from update form has the password field not filled,
            // so we fill it with the current password.
            Personne current = personneService.getPersonneRepository().getById(p.getId());
            p.setPassword(current.getPassword());
        }
        personneService.SavePersonne(p);
        return new ModelAndView("redirect:/");
    }
    @GetMapping("/deletePersonne/{id}")
    public ModelAndView deletePersonne(@PathVariable("id") Long id) {
        personneService.DeletePer(id);
        return new ModelAndView("redirect:/");


    }
}

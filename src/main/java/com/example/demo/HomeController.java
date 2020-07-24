package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("persons", personRepository.findAll());
        return "index";
    }

    @RequestMapping("/addPerson")
    public String addPerson(Model model){
        model.addAttribute("person", new Person());
        return "addPerson";
    }

    @PostMapping("/processPerson")
    public String processPerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/";
    }
    @RequestMapping("/detailPer/{id}")
    public String detailPer(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepository.findById(id).get());
        return "detailPerson";

    }

    @RequestMapping("/updatePer/{id}")
    public String updatePer(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepository.findById(id).get());
        return "addPerson";
    }

    @RequestMapping("/deletePer/{id}")
    public String deletePer(@PathVariable("id") long id){
        personRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/listPets")
    public String listPets(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        return "listPets";
    }

    @RequestMapping("/addPets")
    public String addPets(Model model){
        model.addAttribute("pet", new Pet());
        model.addAttribute("persons", personRepository.findAll());
        return "addPets";
    }



    @PostMapping("/processPet")
    public String processSale(@ModelAttribute Pet pet) {
       petRepository.save(pet);
        return "redirect:/";
    }

    @RequestMapping("/updatePets/{id}")
    public String updatePets(@PathVariable("id") long id, Model model){
        Pet pet = petRepository.findById(id).get();
        model.addAttribute("pet", pet);
        model.addAttribute("persons", personRepository.findAll());
        return "addPets";
    }

    @RequestMapping("/deletePets/{id}")
    public String deletePets(@PathVariable("id") long id){
        petRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/detailPets/{id}")
    public String detailPets(@PathVariable("id") long id, Model model){
     //   Pet pet = petRepository.findById(id).get();
        model.addAttribute("pet", petRepository.findById(id).get());
        return "detailPets";



    }
}

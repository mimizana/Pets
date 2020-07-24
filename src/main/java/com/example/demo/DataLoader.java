package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    @Override
    public void run(String... strings) throws Exception {
        Person person  = new Person();
        person.setName("Olga");

        Pet pet1 = new Pet();
        pet1.setName("Bonya");
        pet1.setType("Cat");
        pet1.setPerson(person);

        Pet pet2 = new Pet();
        pet2.setName("Meenu");
        pet2.setType("Cat");
        pet2.setPerson(person);

        personRepository.save(person);
        petRepository.save(pet1);
        petRepository.save(pet2);

    }
}

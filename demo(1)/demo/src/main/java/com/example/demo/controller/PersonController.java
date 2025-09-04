package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // 🔹 Lire toutes les personnes
    @GetMapping
    public List<Person> getAll() {
        return personService.getAllPersons();
    }

    // 🔹 Créer une nouvelle personne
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    // 🔹 Mettre à jour une personne existante
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        Person person = personService.getPersonById(id);  // Récupère la personne existante
        person.setName(personDetails.getName());
        person.setAge(personDetails.getAge());
        return personService.savePerson(person);          // Mise à jour via save()
    }

    // 🔹 Supprimer une personne
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}

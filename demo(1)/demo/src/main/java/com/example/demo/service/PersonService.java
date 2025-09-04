package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // ⬅️ Indique à Spring que c'est un composant métier
public class PersonService {

    private final PersonRepository personRepository;

    // Spring injecte automatiquement le repository
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Person> getPersonsByName(String name) {
        return personRepository.findByName(name);
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}

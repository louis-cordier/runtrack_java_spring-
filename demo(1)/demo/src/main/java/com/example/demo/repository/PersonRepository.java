package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository n'est pas obligatoire car JpaRepository l'inclut déjà
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // Méthodes prédéfinies par JpaRepository : save, findById, findAll, deleteById, etc.

    // Exemple de méthode générée automatiquement par Spring Data :
    List<Person> findByName(String name);

    List<Person> findByAgeGreaterThan(int age);

    List<Person> findByNameContaining(String keyword);
}

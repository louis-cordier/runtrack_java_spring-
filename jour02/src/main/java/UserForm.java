package com.example.jour02;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserForm {

    @NotBlank(message = "Le prénom est obligatoire")
    private String name;

    @Min(value = 1, message = "L'âge doit être au moins 1")
    private Integer age;

    // Getters et setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}

package com.example.person;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Hobby {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Hobby() {
    }

    public Hobby(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "hobbies")
    private Set<Person> people = new HashSet<>();

    // Getters and Setters

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

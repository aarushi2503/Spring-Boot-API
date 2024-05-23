package com.example.person;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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

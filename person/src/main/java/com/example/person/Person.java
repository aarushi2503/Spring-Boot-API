package com.example.person;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Person {
    @Id
	@GeneratedValue
	private Long id;
	private String name;
    private String address;
    private String phoneNumber;

    public Person() {
		super();
	}

    public Person(Long id, String name, String address, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
        this.phoneNumber = phoneNumber;
	}

    public Person(String name, String address, String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
        this.phoneNumber = phoneNumber;
	}

    @ManyToMany
    @JoinTable(name = "person_hobby",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    private Set<Hobby> hobbies = new HashSet<>();


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

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    public String getPhoneNumber() {
		return phoneNumber;
	}

    public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

}

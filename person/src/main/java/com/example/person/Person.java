package com.example.person;

// Changed from javax to jakarta
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

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

}

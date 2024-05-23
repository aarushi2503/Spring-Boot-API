package com.example.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.person.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}

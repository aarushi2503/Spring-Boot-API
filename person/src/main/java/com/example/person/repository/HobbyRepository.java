package com.example.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.person.model.Hobby;

public interface HobbyRepository extends JpaRepository<Hobby, Long>{

}

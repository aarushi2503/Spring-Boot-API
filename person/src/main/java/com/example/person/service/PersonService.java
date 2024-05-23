package com.example.person.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
        person.setName(personDetails.getName());
        person.setAge(personDetails.getAge());
        person.setAddresses(personDetails.getAddresses());
        person.setPhones(personDetails.getPhones());
        person.setHobbies(personDetails.getHobbies());
        return personRepository.save(person);
    }

    public List<Person> getPersonsByHobby(String hobbyName) {
        return personRepository.findAll().stream()
                .filter(person -> person.getHobbies().stream().anyMatch(hobby -> hobby.getName().equals(hobbyName)))
                .collect(Collectors.toList());
    }

}

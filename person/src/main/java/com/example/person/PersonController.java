package com.example.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private HobbyRepository hobbyRepository;

    @GetMapping
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
        person.setName(personDetails.getName());
        person.setAddress(personDetails.getAddress());
        person.setPhoneNumber(personDetails.getPhoneNumber());
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @PostMapping("/{personId}/hobbies/{hobbyId}")
    public Person addHobbyToPerson(@PathVariable Long personId, @PathVariable Long hobbyId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + personId));
        Hobby hobby = hobbyRepository.findById(hobbyId)
                .orElseThrow(() -> new RuntimeException("Hobby not found with id: " + hobbyId));
        person.getHobbies().add(hobby);
        return personRepository.save(person);
    }

    @DeleteMapping("/{personId}/hobbies/{hobbyId}")
    public Person removeHobbyFromPerson(@PathVariable Long personId, @PathVariable Long hobbyId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + personId));
        Hobby hobby = hobbyRepository.findById(hobbyId)
                .orElseThrow(() -> new RuntimeException("Hobby not found with id: " + hobbyId));
        person.getHobbies().remove(hobby);
        return personRepository.save(person);
    }

}

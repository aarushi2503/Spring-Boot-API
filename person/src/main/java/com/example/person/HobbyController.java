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
@RequestMapping("/hobbies")
public class HobbyController {

    @Autowired
    private HobbyRepository hobbyRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{hobbyName}")
    public List<Person> getPeopleByHobby(@PathVariable String hobbyName) {
        return personRepository.findByHobbiesName(hobbyName);
    }

    @PostMapping
    public Hobby addHobby(@RequestBody Hobby hobby) {
        return hobbyRepository.save(hobby);
    }

    @DeleteMapping("/{id}")
    public void deleteHobby(@PathVariable Long id) {
        hobbyRepository.deleteById(id);
    }

    @GetMapping
    public List<Hobby> getAllHobbies() {
        return hobbyRepository.findAll();
    }

    // @GetMapping("/{id}")
    // public Hobby getHobbyById(@PathVariable Long id) {
    //     return hobbyRepository.findById(id)
    //             .orElseThrow(() -> new RuntimeException("Hobby not found with id: " + id));
    // }

    @PutMapping("/{id}")
    public Hobby updateHobby(@PathVariable Long id, @RequestBody Hobby hobbyDetails) {
        Hobby hobby = hobbyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hobby not found with id: " + id));
        hobby.setName(hobbyDetails.getName());
        return hobbyRepository.save(hobby);
    }

}

package com.example.jvspace.controllers;

import com.example.jvspace.entities.User;
import com.example.jvspace.repositories.UserRepository;
import com.example.jvspace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User userObject){
        userObject = userService.insert(userObject);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userObject.getId()).toUri();
        return ResponseEntity.created(uri).body(userObject);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable String id ,@RequestBody User userObject){
        userObject = userService.update(id, userObject);
        return ResponseEntity.ok().body(userObject);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}

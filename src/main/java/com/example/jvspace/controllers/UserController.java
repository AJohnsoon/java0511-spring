package com.example.jvspace.controllers;

import com.example.jvspace.dto.UserDTO;
import com.example.jvspace.entities.User;
import com.example.jvspace.repositories.UserRepository;
import com.example.jvspace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody User userObject){
        userObject = userService.insert(userObject);
        UserDTO dtoObject = new UserDTO(userObject);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoObject.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoObject);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id ,@RequestBody User userObject){
        userObject = userService.update(id, userObject);
        UserDTO dtoObject = new UserDTO(userObject);
        return ResponseEntity.ok().body(dtoObject);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        if(userService.findById(id).equals(HttpStatus.NOT_FOUND)){
            return ResponseEntity.noContent().build();
        }
        else{
            userService.delete(id);
            return ResponseEntity.ok().build();
        }
    }
}

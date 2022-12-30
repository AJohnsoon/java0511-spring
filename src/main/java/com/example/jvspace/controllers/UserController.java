package com.example.jvspace.controllers;

import com.example.jvspace.entities.Comment;
import com.example.jvspace.entities.Post;
import com.example.jvspace.entities.dto.UserDTO;
import com.example.jvspace.entities.User;
import com.example.jvspace.services.CommentService;
import com.example.jvspace.services.PostService;
import com.example.jvspace.services.UserService;
import com.example.jvspace.utils.FindUserComments;
import com.example.jvspace.utils.FindUserPostage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<Post> postList = postService.findAll();
        List<Comment> commentList = commentService.findAll();
        FindUserPostage.findAllUserPostage(list, postList);
        FindUserComments.findAllUserComments(list, commentList);
        List<UserDTO> listDTO = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        List<Post> postList = postService.findAll();
        List<Comment> commentList = commentService.findAll();
        FindUserPostage.findUserPostage(user, postList);
        FindUserComments.findUserComment(user, commentList);
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

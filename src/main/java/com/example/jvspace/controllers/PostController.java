package com.example.jvspace.controllers;

import com.example.jvspace.dto.PostDTO;
import com.example.jvspace.entities.Post;
import com.example.jvspace.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll(){
        List<Post> list = postService.findAll();
        List<PostDTO> listDTO = list.stream().map(PostDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        Post post = postService.findById(id);
        PostDTO postDTO = new PostDTO(post);
        return ResponseEntity.ok().body(postDTO);
    }

    @PostMapping
    public ResponseEntity<PostDTO> insert(@RequestBody Post postObject){
        postObject = postService.insert(postObject);
        PostDTO dtoObject = new PostDTO(postObject);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoObject.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoObject);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable String id, @RequestBody Post postObject){
        postObject = postService.update(id, postObject);
        PostDTO dtoPost = new PostDTO(postObject);
        return ResponseEntity.ok().body(dtoPost);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        if(postService.findById(id).equals( HttpStatus.NOT_FOUND)){
            return ResponseEntity.noContent().build();
        }
        else{
            postService.delete(id);
            return ResponseEntity.ok().build();
        }
    }

}

package com.example.jvspace.controllers;

import com.example.jvspace.entities.Comment;
import com.example.jvspace.entities.dto.CommentDTO;
import com.example.jvspace.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> findAll(){
        List<Comment> list = commentService.findAll();
        List<CommentDTO> listDTO = list.stream().map(CommentDTO::new).collect( Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable String id){
        Comment comment = commentService.findById(id);
        CommentDTO commentDTO = new CommentDTO(comment);
        return ResponseEntity.ok().body(commentDTO);
    }

    @PostMapping
    public ResponseEntity<CommentDTO> insert(@RequestBody Comment commentObject){
        commentObject = commentService.insert(commentObject);
        CommentDTO dtoObject = new CommentDTO(commentObject);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(dtoObject.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoObject);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> update(@PathVariable String id, @RequestBody Comment commentObject){
        commentObject = commentService.update(id, commentObject);
        CommentDTO dtoComment = new CommentDTO(commentObject);
        return ResponseEntity.ok().body(dtoComment);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        if(commentService.findById(id).equals( HttpStatus.NOT_FOUND)){
            return ResponseEntity.noContent().build();
        }
        else{
            commentService.delete(id);
            return ResponseEntity.ok().build();
        }
    }

}

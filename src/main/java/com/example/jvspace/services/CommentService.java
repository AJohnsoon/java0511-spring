package com.example.jvspace.services;

import com.example.jvspace.entities.Comment;
import com.example.jvspace.repositories.CommentRepository;
import com.example.jvspace.services.exceptions.ResourceNotAcceptableException;
import com.example.jvspace.services.exceptions.ResourceNotFoundException;
import com.example.jvspace.utils.ValidationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findAll(){ return commentRepository.findAll(); }

    public Comment findById(String id){
        Optional<Comment> commentObject = commentRepository.findById(id);
        return commentObject.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Comment insert(Comment commentObject){
        if(commentObject.getAuthor() == null || commentObject.getPostage() == null){
            throw new ResourceNotAcceptableException(commentObject.getId());
        }
        return commentRepository.save(commentObject);
    }

    public Comment update(String id, Comment comment){
        try{
            Comment commentEntity = findById(id);
            ValidationTools.updateCommentVerify(commentEntity, comment);
            return commentRepository.save(commentEntity);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public void delete(String id){
        try{
            commentRepository.deleteById(id);
        }
        catch (RuntimeException e){
            throw new ResourceNotFoundException(id);
        }
    }

}

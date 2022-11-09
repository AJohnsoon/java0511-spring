package com.example.jvspace.services;

import com.example.jvspace.entities.Post;
import com.example.jvspace.repositories.PostRepository;
import com.example.jvspace.services.exceptions.ResourceNotFoundException;
import com.example.jvspace.utils.ValidationTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;


    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(String id){
        Optional<Post> postObject = postRepository.findById(id);
        return postObject.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Post insert(Post postObject){
        return postRepository.insert(postObject);
    }

    public Post update(String id, Post post){
        try{
            Post updateEntity = findById(id);
            ValidationTools.updatePostVerify(updateEntity, post);
            return postRepository.save(updateEntity);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public void delete(String id){
        try{
            postRepository.deleteById(id);
        }
        catch (RuntimeException e){
            throw new ResourceNotFoundException(id);
        }
    }

}

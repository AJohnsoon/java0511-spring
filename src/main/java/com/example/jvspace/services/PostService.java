package com.example.jvspace.services;

import com.example.jvspace.entities.Post;
import com.example.jvspace.repositories.PostRepository;
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
        return postObject.orElseThrow(() -> new RuntimeException());
    }

    public Post insert(Post postObject){
        return postRepository.insert(postObject);
    }

    public Post update(String id, Post post){
        try{
            Post updateEntity = findById(id);
            updateData(updateEntity, post);
            return postRepository.save(updateEntity);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public void delete(String id){
        try{
            postRepository.deleteById(id);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    private void updateData(Post entity, Post post) {
        entity.setTitle(post.getTitle());
        entity.setBody(post.getBody());
    }
}

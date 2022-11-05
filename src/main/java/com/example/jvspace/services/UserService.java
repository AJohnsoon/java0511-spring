package com.example.jvspace.services;

import com.example.jvspace.entities.User;
import com.example.jvspace.repositories.UserRepository;
import com.example.jvspace.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User>userObject  = userRepository.findById(id);
        return userObject.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User insert(User userObject){
        return userRepository.save(userObject);
    }

    public User update(String id, User user){
        User updateEntity = findById(id);
        updateData(updateEntity, user);
        return userRepository.save(updateEntity);
    }

    public void delete(String id){
        try{
            userRepository.deleteById(id);
        }
        catch (RuntimeException e){
            e.getStackTrace();
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

}

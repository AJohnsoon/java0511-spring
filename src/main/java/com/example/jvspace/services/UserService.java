package com.example.jvspace.services;

import com.example.jvspace.entities.Post;
import com.example.jvspace.entities.User;
import com.example.jvspace.repositories.UserRepository;
import com.example.jvspace.services.exceptions.UserNotFoundException;
import com.example.jvspace.utils.UserTools;
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
        return userObject.orElseThrow(() -> new UserNotFoundException(id));
    }

    public User insert(User userObject){
        return userRepository.save(userObject);
    }

    public User update(String id, User user){
        try{
            User updateEntity = findById(id);
            updateData(updateEntity, user);
            return userRepository.save(updateEntity);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            throw new UserNotFoundException(e);
        }
    }

    public void delete(String id){
        try{
            userRepository.deleteById(id);
        }
        catch (RuntimeException e){
            throw new UserNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        UserTools.updateVerify(entity, user);
    }

}

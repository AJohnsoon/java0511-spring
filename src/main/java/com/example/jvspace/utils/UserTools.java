package com.example.jvspace.utils;

import com.example.jvspace.entities.User;

public class UserTools {
    public static void updateVerify(User entity , User user) {
        if(user.getName() != null && user.getEmail() != null && user.getPhone() != null){
            entity.setName(user.getName());
            entity.setEmail(user.getEmail());
            entity.setPhone(user.getPhone());
        }
        else{
            if(user.getName() == null && user.getEmail() == null){
                user.getName();
                user.getEmail();
                entity.setPhone(user.getPhone());
            }
            else if(user.getEmail() == null && user.getPhone() == null){
                user.getEmail();
                user.getPhone();
                entity.setName(user.getName());
            }
            else if(user.getName() == null && user.getPhone() == null){
                user.getName();
                user.getPhone();
                entity.setEmail(user.getEmail());
            }

            else if(user.getName() == null){
                user.getName();
                entity.setEmail(user.getEmail());
                entity.setPhone(user.getPhone());
            }
            else if(user.getEmail() == null){
                user.getEmail();
                entity.setName(user.getName());
                entity.setPhone(user.getPhone());
            }
            else if(user.getPhone() == null){
                user.getPhone();
                entity.setName(user.getName());
                entity.setEmail(user.getEmail());
            }
        }
    }
}

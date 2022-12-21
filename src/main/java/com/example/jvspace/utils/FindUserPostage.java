package com.example.jvspace.utils;

import com.example.jvspace.entities.Post;
import com.example.jvspace.entities.User;

import java.util.List;

public class FindUserPostage {
    public static void findAllUserPostage(List<User> userList, List<Post> listPost){
        for (User user : userList) {
            for (Post post : listPost ) {
               try{
                   if((post.getUser() != null && user.getId() != null) && user.getId().equals(post.getUser().getId())){
                      user.getPostIds().add(post.getId());
                   }
               }
               catch (NullPointerException e){
                   e.getStackTrace();
               }
            }
        }
    }

    public static void findUserPostage(User user, List<Post> listPost){
        for (Post post : listPost){
            try{
                if(user.getId() != null && user.getId().equals(post.getUser().getId())){
                    user.getPostIds().add(post.getId());
                }
            }
            catch (NullPointerException e){
                e.getStackTrace();
            }
        }
    }
}
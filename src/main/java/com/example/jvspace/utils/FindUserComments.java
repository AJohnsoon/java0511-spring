package com.example.jvspace.utils;

import com.example.jvspace.entities.Comment;
import com.example.jvspace.entities.User;

import java.util.List;

public class FindUserComments {
    public static void findAllUserComments(List<User> userList, List<Comment> listPost){
        for (User user : userList) {
            for (Comment comment : listPost ) {
                try{
                    if((comment.getAuthor() != null && user.getId() != null) && user.getId().equals(comment.getAuthor().getId())){
                        user.getCommentsIds().add(comment.getId());
                    }
                }
                catch (NullPointerException e){
                    e.getStackTrace();
                }
            }
        }
    }

    public static void findUserComment(User user, List<Comment> listPost){
        for (Comment comment : listPost){
            try{
                if(user.getId() != null && user.getId().equals(comment.getAuthor().getId())){
                    user.getCommentsIds().add(comment.getId());
                }
            }
            catch (NullPointerException e){
                e.getStackTrace();
            }
        }
    }

}

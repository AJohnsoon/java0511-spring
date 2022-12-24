package com.example.jvspace.utils;

import com.example.jvspace.entities.Comment;
import com.example.jvspace.entities.Post;
import com.example.jvspace.entities.User;

public class ValidationTools {
    public static void updateUserVerify(User entity , User user) {
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

    public static void updatePostVerify(Post entity, Post post){
        if(post.getTitle() != null && post.getBody() != null){
            entity.setTitle(post.getTitle());
            entity.setBody(post.getBody());
        }
        else{
            if(post.getTitle() == null){
                post.getTitle();
                entity.setBody(post.getBody());
            }
            else if(post.getBody() == null){
                post.getBody();
                entity.setTitle(post.getTitle());
            }
        }
    }

    public static void updateCommentVerify(Comment entity, Comment comment){
        if(comment.getComment() != null){
            entity.setComment( comment.getComment());
        }
    }
}

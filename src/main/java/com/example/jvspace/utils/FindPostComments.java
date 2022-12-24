package com.example.jvspace.utils;

import com.example.jvspace.entities.Comment;
import com.example.jvspace.entities.Post;

import java.util.List;

public class FindPostComments {
    public static void findAllPostComments(List<Post> postList, List<Comment> listComment){
        for (Comment comment : listComment) {
            for (Post post : postList ) {
                try{
                    if((comment.getPostage() != null && post.getId() != null) && post.getId().equals(comment.getPostage().getId())){
                        post.getComments().add(comment);
                    }
                }
                catch (NullPointerException e){
                    e.getStackTrace();
                }
            }
        }
    }

    public static void findPostComments(Post postList, List<Comment> listComment){
        for (Comment comment : listComment) {
            try {
                if((comment.getPostage() != null && postList.getId() != null) && postList.getId().equals(comment.getPostage().getId())){
                    postList.getComments().add(comment);
                }
            }
            catch (NullPointerException e){
                e.getStackTrace();
            }
        }
    }


}

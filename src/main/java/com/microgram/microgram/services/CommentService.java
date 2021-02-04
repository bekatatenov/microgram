package com.microgram.microgram.services;

import com.microgram.microgram.dto.CommentDto;
import com.microgram.microgram.exception.ResourceNotFoundException;
import com.microgram.microgram.models.Comment;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import com.microgram.microgram.repositories.CommentRepositories;
import com.microgram.microgram.repositories.PostRepositories;
import com.microgram.microgram.repositories.UserRepositories;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    CommentRepositories commentRepositories;
    PostRepositories postRepositories;
    UserRepositories userRepositories;

    public Slice<CommentDto> findCommentByPostId(Pageable pageable, String postId) {
        Slice<Comment> comments = commentRepositories.findAllByPostId(pageable, postId);
        return comments.map(CommentDto::from);
    }

    public CommentDto addComment(CommentDto commentData, String postId, String userId) {
        Post post = postRepositories.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("There is not such a post with " + postId + "id"));

        User user = userRepositories.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("There is no such a user with " + userId + " id"));

        Comment newComment = new Comment(post, commentData.getText(), commentData.getDate(), user);
        commentRepositories.save(newComment);
        return CommentDto.from(newComment);
    }

    public boolean deleteComment(String commentId) {
        commentRepositories.deleteById(commentId);
        return true;
    }
    public Comment findById(String id) {
        return commentRepositories.findById(id).orElseThrow(()->
                new ResourceNotFoundException("There is no such comment"));
    }
}

package com.microgram.microgram.dto;

import com.microgram.microgram.models.Comment;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class CommentDto {
    private String id;
    private Post post;
    private String text;
    private LocalDate date;
    private User user;

    public static CommentDto from(Comment comment) {
        return builder()
                .id(comment.getId())
                .post(comment.getPost())
                .text(comment.getText())
                .date(comment.getDate())
                .user(comment.getUser())
                .build();
    }
}

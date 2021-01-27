package com.microgram.microgram.dto;


import com.microgram.microgram.models.Like;
import com.microgram.microgram.models.Post;
import com.microgram.microgram.models.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class LikeDto {
    private String id;
    private User user;
    private Post post;
    private LocalDate date;

    public static LikeDto from(Like like) {
        return builder()
                .id(like.getId())
                .date(like.getDate())
                .post(like.getPost())
                .user(like.getUser())
                .build();
    }
}

package com.microgram.microgram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Like {
    @Id
    private Integer id;
    private User whoLiked;
    private Post likedPost;
    private LocalDate dateOfLike;
}

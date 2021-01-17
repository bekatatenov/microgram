package com.microgram.microgram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Post {
    @Id
    private Integer id;
    private String pathForImage;
    private String description;
    private LocalDate dateOfPost;
}

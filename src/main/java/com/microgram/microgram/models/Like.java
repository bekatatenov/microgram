package com.microgram.microgram.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;

@Document(collection = "likes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Like {
    @Id
    private Integer id;

    @DBRef
    private User user;

    @DBRef
    private Post post;

    private LocalDate date;

}

package com.microgram.microgram.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "subs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscription {
    @Id
    private Integer id;
    @DBRef
    private User toUser;
    @DBRef
    private User doUser;
    private LocalDate date;

}

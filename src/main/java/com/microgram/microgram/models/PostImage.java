package com.microgram.microgram.models;


import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "postImages")
public class PostImage {
    public static final PostImage NO_IMAGE = PostImage.builder().id("-NO-IMAGE-").build();
    @Id
    @Builder.Default
    private final String id = UUID.randomUUID().toString();
    @Builder.Default
    private final Binary postData = new Binary(new byte[0]);
}

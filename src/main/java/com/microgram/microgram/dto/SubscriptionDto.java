package com.microgram.microgram.dto;


import com.microgram.microgram.models.Subscription;
import com.microgram.microgram.models.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class SubscriptionDto {
    private String id;
    private User user;
    private User toUser;
    private LocalDate date;

    public static SubscriptionDto from(Subscription subscription) {
        return builder()
                .id(subscription.getId())
                .user(subscription.getUser())
                .toUser(subscription.getToUser())
                .date(subscription.getDate())
                .build();
    }
}

package com.microgram.microgram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Subscription {
    @Id
    private Integer id;
    private User subscribeFrom;
    private User subscribeTo;
    private LocalDate date;
}
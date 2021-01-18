package com.microgram.microgram.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "subs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fromUser")
    private User toUser;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "toUser")
    private User doUser;
    @Column
    private LocalDate date;

}

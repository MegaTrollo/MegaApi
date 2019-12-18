package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    private String description;

    private Date actionDate;

    public Activity(User user, Card card, String description, Date actionDate) {
        this.user = user;
        this.card = card;
        this.description = description;
        this.actionDate = actionDate;
    }

    public Activity() {
    }
}

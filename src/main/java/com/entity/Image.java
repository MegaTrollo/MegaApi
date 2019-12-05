package com.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String type;
    @Lob
    private byte[] pic;
    // private Blob photo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "comment_id")
//    private Comment comment;

    public Image(String name, String type, byte[] pic, Card card) {
        this.name = name;
        this.type = type;
        this.pic = pic;
        this.card = card;
    }

    public Image() {
    }
}

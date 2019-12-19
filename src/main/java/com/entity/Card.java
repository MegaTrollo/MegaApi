package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String description;

    private Boolean isArchive = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cardListId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CardList cardListId;

    @OneToMany(mappedBy = "card")
    private List<Image> images;

    @OneToMany(mappedBy = "card")
    private List<Activity> activity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "labels", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Label> labels;

    public Card(String name, String description, CardList cardListId, List<Image> images) {
        this.name = name;
        this.description = description;
        this.cardListId = cardListId;
        this.images = images;
    }
}

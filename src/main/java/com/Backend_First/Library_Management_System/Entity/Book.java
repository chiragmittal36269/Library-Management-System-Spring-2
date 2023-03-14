package com.Backend_First.Library_Management_System.Entity;

import com.Backend_First.Library_Management_System.Enum.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int price;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private boolean isIssued;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;
    // here we use single class instead of list of class like List<Author>
    // why i am not using this because many books have one author


    // one book have many transactions so we write this in the list
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> transaction = new ArrayList<>();
    // here we create an empty list because at the starting there is having an empty list.


    @ManyToOne
    @JoinColumn
    LibraryCard card;
}

package com.Backend_First.Library_Management_System.Entity;

import com.Backend_First.Library_Management_System.Enum.CardStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String validTill;

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @OneToOne           // here relation is child and parent.
    @JoinColumn         // join column will take care of primary key otherwise we pass the whole student class.
    @JsonIgnore
    Student student;    // here we pass the whole student class.
}

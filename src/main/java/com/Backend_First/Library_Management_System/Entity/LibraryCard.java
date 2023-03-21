package com.Backend_First.Library_Management_System.Entity;

import com.Backend_First.Library_Management_System.Enum.CardStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    private String validTill;

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @CreationTimestamp
    private Date creationDate;

//    @CreationTimestamp
    @UpdateTimestamp
    private Date updationDate;

    @OneToOne           // here relation is child and parent.
    @JoinColumn         // join column will take care of primary key otherwise we pass the whole student class.
    @JsonIgnore
    Student student;    // here we pass the whole student class.



    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> bookList = new ArrayList<>();
}

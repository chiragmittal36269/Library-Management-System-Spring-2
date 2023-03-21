package com.Backend_First.Library_Management_System.Entity;

import com.Backend_First.Library_Management_System.Enum.CardStatus;
import com.Backend_First.Library_Management_System.Enum.Department;
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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true)  // for unique email
    private String email;

    @Enumerated(EnumType.STRING)
    private Department department;


    // mappedBy is always written in parent class
    // here we write the key of parent class which helps to join two tables
    // here relation is parent to child
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    LibraryCard card;   // here  we use single class because each student is having only single card.
}

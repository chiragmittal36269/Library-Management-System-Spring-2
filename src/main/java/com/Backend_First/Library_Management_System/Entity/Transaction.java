package com.Backend_First.Library_Management_System.Entity;

import com.Backend_First.Library_Management_System.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionNumber;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date transactionDate;

    private String message;

    private boolean isIssueOperation;

    @ManyToOne
    @JoinColumn
    Book book;


    @ManyToOne
    @JoinColumn
    LibraryCard card;
}

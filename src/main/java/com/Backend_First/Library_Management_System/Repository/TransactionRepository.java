package com.Backend_First.Library_Management_System.Repository;

import com.Backend_First.Library_Management_System.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}

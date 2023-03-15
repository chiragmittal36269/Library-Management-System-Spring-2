package com.Backend_First.Library_Management_System.Repository;

import com.Backend_First.Library_Management_System.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    // custom queries
    @Query(value = "select * from Transaction t where t.card_id=:cardId AND t.transaction_status='SUCCESS'",nativeQuery = true)
    List<Transaction> getAllSuccessfulTransactionsWithCardNo(int cardId);

}

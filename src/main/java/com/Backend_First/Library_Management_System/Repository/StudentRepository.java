package com.Backend_First.Library_Management_System.Repository;

import com.Backend_First.Library_Management_System.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // create self function
    // like findBy{name of attribute but first letter is on caps}
    // ORM will implement these functions
    Student findByEmail(String email);  // custom Search based on attribute
    List<Student> findByName(String name);
    List<Student> findByAge(int age);


    // custom Queries
//    @Query(value = "select * from Transaction t where t.card_id=:cardId AND t.transaction_status='SUCCESS'",nativeQuery = true)
//    List<Transaction> getAllSuccessfulTransactionsWithCardNo(int cardId);

//      if we write custom query then it will oly take the String as an input, so it is difficult to read Enum in custom query
//      IMPORTANT THINGS : Custom Queries has own name, so we write @Query over it but in case Custom function which start with findBy(name of attribute) there is no need to add anything over it
//      because it is already defined in jpa and implementation is handled by orm

}

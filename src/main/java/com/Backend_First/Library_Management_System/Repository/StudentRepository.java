package com.Backend_First.Library_Management_System.Repository;

import com.Backend_First.Library_Management_System.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // create self function like findBy{name of attribute but first letter is on caps}
    // ORM will implement these functions
    Student findByEmail(String email);  // custom Search based on attribute
    List<Student> findByAge(int age);

}

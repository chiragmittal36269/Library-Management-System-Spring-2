package com.Backend_First.Library_Management_System.Repository;

import com.Backend_First.Library_Management_System.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}

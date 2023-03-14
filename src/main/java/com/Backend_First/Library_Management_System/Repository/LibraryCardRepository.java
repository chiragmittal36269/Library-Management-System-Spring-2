package com.Backend_First.Library_Management_System.Repository;

import com.Backend_First.Library_Management_System.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
}

package com.grupo5.homework_java_ironlibrary.repositories;

import com.grupo5.homework_java_ironlibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    // Custom query methods can be defined here if needed
}

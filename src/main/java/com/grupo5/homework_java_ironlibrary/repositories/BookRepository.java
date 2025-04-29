package com.grupo5.homework_java_ironlibrary.repositories;

import com.grupo5.homework_java_ironlibrary.models.Author;
import com.grupo5.homework_java_ironlibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    // Custom query methods can be defined here if needed
    List<Book> findByTitle(String title);

    @Query("SELECT i.issueBook FROM Issue i JOIN i.issueStudent s WHERE s.usn = :usn")
    Book findByUsn(@Param("usn")String usn);

    List<Book> findByCategory(String category);




}

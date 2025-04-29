package com.grupo5.homework_java_ironlibrary.repositories;

import com.grupo5.homework_java_ironlibrary.models.Author;
import com.grupo5.homework_java_ironlibrary.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("SELECT a.authorBook FROM Author a WHERE a.name = :authorName")
    Optional<Book> findBookByAuthorName(@Param("authorName") String authorName);

}




package com.grupo5.homework_java_ironlibrary.models;

import com.grupo5.homework_java_ironlibrary.repositories.AuthorRepository;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import com.grupo5.homework_java_ironlibrary.repositories.IssueRepository;
import com.grupo5.homework_java_ironlibrary.repositories.StudentRepository;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class LibraryHandler {

        private final BookRepository bookRepo;

        private AuthorRepository authorRepo;

        private IssueRepository issueRepo;

        private StudentRepository studentRepository;

        public LibraryHandler(BookRepository bookRepo) {
            this.bookRepo = bookRepo;
        }


}

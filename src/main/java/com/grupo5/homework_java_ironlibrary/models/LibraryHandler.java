package com.grupo5.homework_java_ironlibrary.models;

import com.grupo5.homework_java_ironlibrary.HomeworkJavaIronlibraryApplication;
import com.grupo5.homework_java_ironlibrary.repositories.AuthorRepository;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import com.grupo5.homework_java_ironlibrary.repositories.IssueRepository;
import com.grupo5.homework_java_ironlibrary.repositories.StudentRepository;

public class LibraryHandler {
    private static AuthorRepository authorRepository;
    private static BookRepository bookRepository;
    private static IssueRepository issueRepository;
    private static StudentRepository studentRepository;
}

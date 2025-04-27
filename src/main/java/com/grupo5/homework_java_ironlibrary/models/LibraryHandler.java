package com.grupo5.homework_java_ironlibrary.models;

import com.grupo5.homework_java_ironlibrary.repositories.AuthorRepository;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import com.grupo5.homework_java_ironlibrary.repositories.IssueRepository;
import com.grupo5.homework_java_ironlibrary.repositories.StudentRepository;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.transform.SourceLocator;
import java.util.Optional;


public class LibraryHandler {


    private StudentRepository studentRepository;
    private BookRepository bookRepository;
    private IssueRepository issueRepository;
    private AuthorRepository authorRepository;

    public LibraryHandler(StudentRepository studentRepository, BookRepository bookRepository, IssueRepository issueRepository, AuthorRepository authorRepository) {
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
        this.issueRepository = issueRepository;
        this.authorRepository = authorRepository;
    }

    public void findStudentById( String id) {
        System.out.println(studentRepository.findById(id));
    }

    public void findBookByTitle(String title) {
        System.out.println(bookRepository.findByTitle(title));
    }

    public void findBookByUsn(String category) {
        System.out.println(bookRepository.findByUsn(category));
    }

    public void findBookByCategory(String category) {
        System.out.println(bookRepository.findByCategory(category));
    }

    public void findBookByAuthorName(String authorsName){
        Optional<Book> bookOp = bookRepository.findBookByAuthorName(authorsName);
        if (bookOp.isPresent()){
            Book book = bookOp.get();
            System.out.println(book);
        }
    }



}

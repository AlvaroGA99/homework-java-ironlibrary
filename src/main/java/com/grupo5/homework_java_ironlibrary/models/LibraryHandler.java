package com.grupo5.homework_java_ironlibrary.models;

import com.grupo5.homework_java_ironlibrary.repositories.AuthorRepository;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import com.grupo5.homework_java_ironlibrary.repositories.IssueRepository;
import com.grupo5.homework_java_ironlibrary.repositories.StudentRepository;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;


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

    public void addBook(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter isbn: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter Author name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter Author mail: ");
        String authorEmail = scanner.nextLine();

        System.out.print("Enter number of books: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setCategory(category);
        book.setQuantity(quantity);

        Author author = new Author();
        author.setName(authorName);
        author.setEmail(authorEmail);
        author.setAuthorBook(book);

        book.setAuthor(author);
       //Solo hacemos save de book porque con cascade ALL tambien guarda el autor y si se borra el libro tambien se borra el author
        bookRepository.save(book);



        System.out.println("Book and author saved!");
    }

}

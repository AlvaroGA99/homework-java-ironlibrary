package com.grupo5.homework_java_ironlibrary;

import com.grupo5.homework_java_ironlibrary.models.LibraryHandler;
import com.grupo5.homework_java_ironlibrary.models.Student;
import com.grupo5.homework_java_ironlibrary.repositories.AuthorRepository;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import com.grupo5.homework_java_ironlibrary.repositories.IssueRepository;
import com.grupo5.homework_java_ironlibrary.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class HomeworkJavaIronlibraryApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(HomeworkJavaIronlibraryApplication.class, args);
	}

	@Override
	public void run(String... args){

		LibraryHandler handler = new LibraryHandler(studentRepository,bookRepository,issueRepository,authorRepository);

		Scanner scanner = new Scanner(System.in);
		int option = 0;
		while (option != 8) {
			System.out.println("Select an option:");
			System.out.println("---------------------------------");
			System.out.println("1. Add a book");
			System.out.println("2. Search a book by title");
			System.out.println("3. Search a book by category");
			System.out.println("4. Search a book by author");
			System.out.println("5. List all books along with their authors");
			System.out.println("6. Issue book to student");
			System.out.println("7. list books by usn");
			System.out.println("8. Exit");
			System.out.println("---------------------------------");
			option = scanner.nextInt();
			switch (option) {
				case 1:
					System.out.println("Add a book");
					handler.findStudentById("1RV23CS001");
					break;
				case 2:
					System.out.println("Search a book by title");
					handler.findBookByTitle("Java Programming");
					break;
				case 3:
					System.out.println("Search a book by category");
					break;
				case 4:
					System.out.println("Search a book by author");
					break;
				case 5:
					System.out.println("List all books along with their authors");
					break;
				case 6:
					System.out.println("Issue book to student");
					break;
				case 7:
					System.out.println("List books by usn");
					handler.findBookByUsn("usn");
					break;
				case 8:
					System.out.println("Exit");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid option");
					System.out.println();
					break;
			}

		}

		scanner.close();
	}


	public void findStudent(StudentRepository r,String usn){
		r.findById(usn);

	}

}

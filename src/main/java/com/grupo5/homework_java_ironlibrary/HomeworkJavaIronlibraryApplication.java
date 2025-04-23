package com.grupo5.homework_java_ironlibrary;

import com.grupo5.homework_java_ironlibrary.models.Student;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import com.grupo5.homework_java_ironlibrary.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class HomeworkJavaIronlibraryApplication {



	public static void main(String[] args) {


		ConfigurableApplicationContext ctx = SpringApplication.run(HomeworkJavaIronlibraryApplication.class, args);

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
					HomeworkJavaIronlibraryApplication app = ctx.getBean(HomeworkJavaIronlibraryApplication.class);
					app.findStudent("1RV23CS001");
					break;
				case 2:
					System.out.println("Search a book by title");
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
					System.out.println("list books by usn");
					break;
				case 8:
					System.out.println("Exit");
					break;
				default:
					System.out.println("Invalid option");
					System.out.println();
					break;
			}

		}

		scanner.close();

		SpringApplication.exit(ctx, () -> 0);




	}

	@Autowired
	private StudentRepository studentRepo;

	public void findStudent(String usn){
		Optional<Student> s =studentRepo.findById(usn);
		if(s.isPresent()){
		System.out.println(s);}
	}

}

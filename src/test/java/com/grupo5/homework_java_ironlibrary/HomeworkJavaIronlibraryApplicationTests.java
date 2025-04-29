
package com.grupo5.homework_java_ironlibrary;

import com.grupo5.homework_java_ironlibrary.models.Author;
import com.grupo5.homework_java_ironlibrary.models.Book;
import com.grupo5.homework_java_ironlibrary.models.Issue;
import com.grupo5.homework_java_ironlibrary.models.Student;
import com.grupo5.homework_java_ironlibrary.repositories.AuthorRepository;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import com.grupo5.homework_java_ironlibrary.repositories.IssueRepository;
import com.grupo5.homework_java_ironlibrary.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class HomeworkJavaIronlibraryApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private StudentRepository studentRepository;


	@BeforeAll
	static void prepareInput() {
		// Antes de que Spring Boot levante el contexto
		String simulatedInput = "8\n"; // Simulamos que escribimos "8" y presionamos enter
		System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
	}
	@Test
	void searchBookByTitleTest() {

		Book book = new Book();
		book.setIsbn("111");
		book.setTitle("Test Book");
		book.setCategory("Programming");
		book.setQuantity(10);
		bookRepository.save(book);

		var bookByTitle = bookRepository.findByTitle("Test Book");

		assertNotNull(bookByTitle);
		for(Book b : bookByTitle){
			assertEquals("Test Book", b.getTitle());
		}

	}

	@Test
	void searchBookByCategoryTest() {

		Book book = new Book();
		book.setIsbn("222");
		book.setTitle("Book of Testing");
		book.setCategory("Programming");
		book.setQuantity(1);
		bookRepository.save(book);

		var bookByCat = bookRepository.findByCategory("Programming");

		assertNotNull(bookByCat);
		for(Book b : bookByCat){
			assertEquals("Programming", b.getCategory());
		}

	}


	@Test
	void findBookByAuthorNameTest() {

		Book book = new Book();
		book.setIsbn("444");
		book.setTitle("The testing book");
		book.setCategory("Authoring");
		book.setQuantity(2);
		bookRepository.save(book);
		Author author = new Author();
		author.setName("John Doe");
		author.setEmail("mail@mail.com");
		author.setAuthorBook(book);
		authorRepository.save(author);

		Optional<Book> optionalBookByauthor = authorRepository.findBookByAuthorName(author.getName());

		optionalBookByauthor.ifPresent(value -> {
			assertEquals("Authoring", value.getCategory());
			assertEquals("The testing book", value.getTitle());
		});

	}


	@Test
	void listAllBooksWithAuthors() {

		Book book1 = new Book();
		book1.setIsbn("666");
		book1.setTitle("Java for Beginners");
		book1.setCategory("Programming");
		book1.setQuantity(5);
		bookRepository.save(book1);

		Book book2 = new Book();
		book2.setIsbn("555");
		book2.setTitle("Advanced Java");
		book2.setCategory("Programming");
		book2.setQuantity(3);
		bookRepository.save(book2);

		Author author1 = new Author();
		author1.setName("Jane Doe");
		author1.setEmail("jane.doe@mail.com");
		author1.setAuthorBook(book1);
		authorRepository.save(author1);

		Author author2 = new Author();
		author2.setName("John Smith");
		author2.setEmail("john.smith@mail.com");
		author2.setAuthorBook(book2);
		authorRepository.save(author2);

		List<Author> authors = authorRepository.findAll();

		for (Author author : authors) {
			Book book = author.getAuthorBook();
			assertNotNull(book);
			if(book.getTitle().equals("Java for Beginners")){
				assertEquals("Jane Doe", author.getName());
			}else if(book.getTitle().equals("Advanced Java")){
				assertEquals( "John Smith", author.getName());
			}
		}
	}

	@Test
	void findBookByUsnTest() {

		Book book = new Book();
		book.setIsbn("777");
		book.setTitle("The testing book");
		book.setCategory("Authoring");
		book.setQuantity(2);
		bookRepository.save(book);

		Student student = new Student();
		student.setUsn("abcabc");
		student.setName("John Student");
		studentRepository.save(student);

		Issue issue = new Issue();
		issue.setIssueBook(book);
		issue.setIssueStudent(student);
		issue.setIssueDate("2023-10-01");
		issue.setReturnDate("2023-10-15");
		issueRepository.save(issue);

		System.out.println("Book: " + book.getTitle()
				+ ", Student: " + student.getName()
		+ ", Issue Date: " + issue.getIssueDate());

		Book bookByUsn = bookRepository.findByUsn("abcabc");

		System.out.println(bookByUsn);

		assertNotNull(bookByUsn);
		assertEquals("The testing book", bookByUsn.getTitle());
		assertEquals("Authoring", bookByUsn.getCategory());
		assertEquals(2, bookByUsn.getQuantity());
	}
}

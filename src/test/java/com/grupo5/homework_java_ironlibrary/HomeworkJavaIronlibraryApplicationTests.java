package com.grupo5.homework_java_ironlibrary;

import com.grupo5.homework_java_ironlibrary.models.Book;
import com.grupo5.homework_java_ironlibrary.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class HomeworkJavaIronlibraryApplicationTests {

	@Autowired
	private BookRepository bookRepository;

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

}

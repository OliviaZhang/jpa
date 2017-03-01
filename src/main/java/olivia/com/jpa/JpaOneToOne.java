package olivia.com.jpa;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import olivia.com.jpa.model.Book;
import olivia.com.jpa.model.BookDetail;
import olivia.com.jpa.repository.BookRepository;

@SpringBootApplication
public class JpaOneToOne implements CommandLineRunner {
	
	//private static final Logger logger = LoggerFactory.getLogger(JpaOneToOne.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOne.class, args);
	}
	
	public void run(String... strings) throws Exception {
		List<Book> books = new ArrayList<>();
		
		books.add(new Book("Book A", new BookDetail(49)));
		books.add(new Book("Book B", new BookDetail(59)));
		books.add(new Book("Book C", new BookDetail(69)));
		
		bookRepository.save(books);
		
		for (Book book : bookRepository.findAll()) {
			System.out.println(book.toString());
		}
		
	}
	
}

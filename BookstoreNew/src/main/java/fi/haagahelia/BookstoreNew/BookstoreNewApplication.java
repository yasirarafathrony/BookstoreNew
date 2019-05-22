package fi.haagahelia.BookstoreNew;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.BookstoreNew.domain.BookNew;
import fi.haagahelia.BookstoreNew.domain.BookNewRepository;

@SpringBootApplication
public class BookstoreNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreNewApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner demo(BookNewRepository repository) {
		
		return (args) ->{
			
			BookNew s1 = new BookNew ("A Farewell to Arms", "Ernest Hemingway", 1929, 1232323-21, 20);
			BookNew s2 = new BookNew ("Animal Farm", "George Orwell", 1945, 2212343-5, 40);
			
			repository.save(s1);
			repository.save(s2);
			
		};
	}
}

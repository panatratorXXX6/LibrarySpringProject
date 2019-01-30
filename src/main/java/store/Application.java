package store;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import store.domain.Author;
import store.domain.Book;
import store.repository.AuthorRepository;
import store.repository.BookRepository;

@SpringBootApplication
public class Application {
	
    public static void main(String[]args) throws Exception {
    	SpringApplication.run(Application.class, args);
    		
    }
    
//	    @Bean
//	    public CommandLineRunner demo(BookRepository bookRepo, AuthorRepository authorRepo) {
//	    	return (args) -> {
//	    	Book book1 = new Book("111-234-689", "Digit Castle", 25, new Date(50), 230, getSomeAuthor(1));
//	    	Book book2 = new Book("222-234-689", "Alhimic", 25, new Date(43), 230, getSomeAuthor(2));
//	    	Book book3 = new Book("333-234-689", "Rich Dad, poor Dad", 25, new Date(15), 230, getSomeAuthor(3));
//	    	Author author1 = new Author("Dan Brown", new Date(10), "Horror", "Stephen King", null);
//	    	Author author2 = new Author("Paulo Koelo", new Date(11), "Novel", "Dan Brown", null);
//	    	Author author3 = new Author("Robert Kiosaki", new Date(13), "Detective Story", "Konan Doehl", null);
//    
//	    	Set<Author> authorSet = new HashSet<>();
//	    	authorSet.add(author1);
//	    	authorSet.add(author2);
//	    	book1.setAuthor(authorSet);
//	    	
//	    	bookRepo.save(book1);
//	    	bookRepo.save(book2);
//	    	bookRepo.save(book3);
//	    	authorRepo.save(author1);
//	    	authorRepo.save(author2);
//	    	authorRepo.save(author3);
//	    };
//	}
//	    
//	    	Set<Author> getSomeAuthor (int count) {
//	    		Set<Author> firstauthor = new HashSet<>();
//	    			switch(count) {
//	    				case 3:firstauthor.add(new Author("Dan Brown", new Date(41), "USA", "Horror", null)); 
//	    	
//	    				case 2:firstauthor.add(new Author("Paulo Koelo", new Date(41), "USA", "Horror", null)); 
//	    				
//	    				case 1:firstauthor.add(new Author("Robert Kiosaki", new Date(41), "USA", "Horror", null)); 
//	    		}
//	    		return firstauthor;
//	    	
//	    	}
	    }


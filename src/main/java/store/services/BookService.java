package store.services;

import java.util.List;
import java.util.Set;

import store.domain.Book;

public interface BookService {
	
	Book findBookById(Integer id);
	
	List<Book> getAllBooks();
}

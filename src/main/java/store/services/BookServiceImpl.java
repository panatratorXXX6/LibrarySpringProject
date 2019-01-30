package store.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.domain.Book;
import store.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public Book findBookById(Integer id) {
		
		return bookRepo.findById(id).orElseThrow(RuntimeException::new);
	}	
	
	@Override
	public List<Book> getAllBooks() {
		return (List<Book>) bookRepo.findAll();
	}
}

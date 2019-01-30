package store.services;

import java.util.List;

import store.domain.Author;

public interface AuthorService {
	
	Author findAuthorById(Integer id);
	
	// Quantity of authors
	int amountOfAuthors();
	
	// The youngest author
	Author getTheYoungestAuthor(List<Author> list);
	
	// The oldest author
	Author getTheOldestAuthor(List<Author> list);
	
	// The best-selling author
	Author getTheBestSellingAuthor(List<Author> list);
	
	// The least-selling author
	Author getTheLeastSellingAuthor(List<Author> list);
	
	// The most efficient author
	Author getTheMostEfficientAuthor(List<Author> list);
	
	
}

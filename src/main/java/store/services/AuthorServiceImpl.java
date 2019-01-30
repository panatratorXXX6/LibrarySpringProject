package store.services;


import java.util.Collections;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.domain.Author;
import store.domain.Book;
import store.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	public AuthorRepository authorRepo;

	
	@Override
	public Author findAuthorById(Integer id) {
		return authorRepo.findById(id).orElseThrow(RuntimeException::new);
	}

// show amount of all authors	
	@Override
	public int amountOfAuthors() {
		List<Author> list = (List<Author>) authorRepo.findAll();
		return list.size();
	}
	
// show what author is the most old	
	@Override
	public Author getTheYoungestAuthor(List<Author> list) {
		
		Collections.sort(list, new Comparator<Author>() {
			@Override
			public int compare(Author author1, Author author2) {
				return author1.getBirthday().compareTo(author2.getBirthday());
			}
		});
		return list.get(list.size()-1);
	}

// show what author is the most young		
	@Override
	public Author getTheOldestAuthor(List<Author> list) {
		
		Collections.sort(list, new Comparator<Author>() {
			@Override
			public int compare(Author author1, Author author2) {
				return author1.getBirthday().compareTo(author2.getBirthday());
			}
		});
		return list.get(0);
	}
	
// Method show the current author who has sold more books than another authors in a bundle 	
	@Override
	public Author getTheBestSellingAuthor(List<Author> list) {

		int bestPrinting = 0;
		int maxValue = 0;
		Author bestAuthor = null;
		
		for (Author a: list) {
			Set<Book> books = a.getBookofauthors();
			
			for (Book b: books) {
				bestPrinting = b.getCount() + bestPrinting;
				
				} 
				if(bestPrinting > maxValue) {
					maxValue = bestPrinting;
					bestAuthor = a;
				}
				bestPrinting=0;
		}
		return bestAuthor;
	}

// Method show the current author who has sold less books than another authors in a bundle 	
	@Override
	public Author getTheLeastSellingAuthor(List<Author> list) {
		
		int minValue = Integer.MAX_VALUE;
		int printing = 0;
		Author leastAuthor = null;
		
		for (Author currentAuthor: list) {
			Set<Book> books = currentAuthor.getBookofauthors();
			
			for (Book b: books) {
				printing = b.getCount() + printing;
				
				} if(printing < minValue) {
					minValue = printing;
					leastAuthor = currentAuthor;
				}
				printing=0;
		}
		return leastAuthor;
	}

 // The most efficient author (Current author's printing/current author's books)	
	@Override
	public Author getTheMostEfficientAuthor(List<Author> list) {
		
		int printing = 0;
		Author mostEfficientAuthor = null;
		int koefValue = 0;
		int bestValue = 0;
		
		for (Author a: list) {
			Set<Book> books = a.getBookofauthors();
			
			for(Book b: books) {
				printing = b.getCount() + printing;
			} 
			
			try {
				koefValue = printing / books.size();
				}
			catch (ArithmeticException e) {
				
			}
			
			if (koefValue > bestValue) {
				bestValue = koefValue;
				mostEfficientAuthor = a;
			}
			printing = 0; // update printing of author's books
		}
		return mostEfficientAuthor;
	}
}



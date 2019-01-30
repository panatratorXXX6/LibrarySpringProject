package store.controller;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import store.domain.Author;
import store.domain.Book;
import store.repository.AuthorRepository;
import store.repository.BookRepository;
import store.services.AuthorService;
import store.services.BookService;

@Controller
@RequestMapping(path="/login")
public class WebController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
// Getting form of book to fill data about current book
	@GetMapping("/formbook")
	public String getFormBook(Model model) {
		model.addAttribute("book", new Book());
		return "formbook";
	}

// Getting table of books	
	@GetMapping("/book")
    public String getTableBook(Model model) {
        model.addAttribute("book", bookRepo.findAll());
        return "tablebook";
    }

// Edit book by id
	@RequestMapping(path="/book/{id}")
	public String getEditBook(@PathVariable("id") Integer id, Model model) {
		 model.addAttribute("book", bookService.findBookById(id));
		 return "editbook";
	}
	
// Update the book	
	@RequestMapping(path="/editbook", method = RequestMethod.POST)
	public String editBook(@Valid Book book) {
		bookRepo.save(book);
		return "redirect:book";
	}
	
// Adding new book
	@PostMapping(path="/addbook")
	public String addNewBook(@ModelAttribute Book book) {
		bookRepo.save(book);
		return "redirect:book";
	}
	
// Deleting current book	
	@RequestMapping(path="/deletebook")
	public String getDeleteBook(@RequestParam("id") Integer id) {
		bookRepo.deleteById(id);
		return "redirect:book";
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

// Getting form of author to fill data about current author	
	@GetMapping("/formauthor")
	public String getFormAuthor(Model model) {
		model.addAttribute("author", new Author());
		return "formauthor";
	}

// Getting table of books		
	@GetMapping("/author")
    public String getTableAuthor(Model model) {
		
		List <Author> list = (List<Author>) authorRepo.findAll();
		
		model.addAttribute("countOfAuthor", authorService.amountOfAuthors());
		model.addAttribute("oldestAuthor", authorService.getTheOldestAuthor(list));
		model.addAttribute("youngestAuthor", authorService.getTheYoungestAuthor(list));
		model.addAttribute("bestAuthor", authorService.getTheBestSellingAuthor(list));
		model.addAttribute("leastAuthor", authorService.getTheLeastSellingAuthor(list));
		model.addAttribute("efficientAuthor", authorService.getTheMostEfficientAuthor(list));
        model.addAttribute("author", authorRepo.findAll());
        
        return "tableauthor";
    }
	
// Editing author by id	
	@RequestMapping(path="/author/{id}")
	public String getEditAuthor(@PathVariable("id") Integer id, Model model) {
		
		Author author = authorService.findAuthorById(id);
		List<Integer> list = new ArrayList<>();
		
		for (Book b: author.getBookofauthors()) {
			list.add(b.getId());
		}
		
		author.getBookofauthors();
		
		model.addAttribute("author", author);
		model.addAttribute("authorBooks", bookService.getAllBooks());
		model.addAttribute("authorBooksId", list);
		return "editauthor";
	}

// Get description of author	
	@RequestMapping(path="/ajaxauthor/{id}", produces="application/json")
	@ResponseBody
	public Map<String, String> getDescriptionAuthor(@PathVariable("id") Integer id) {
		Author author = authorService.findAuthorById(id);
		
		Map<String, String> authorMap = new HashMap<>();
		authorMap.put("name", author.getName());
		authorMap.put("address", author.getAddress());
		authorMap.put("description", author.getDescription());
		return authorMap;
	}
	
// Update the book
	@RequestMapping(path="/editauthor", method=RequestMethod.POST)
	public String editAuthor(@Valid Author author) {
		authorRepo.save(author);
		return "redirect:author";
	}
	
// Adding new author
	@PostMapping(path="/addauthor")
	public String addNewAuthor(@ModelAttribute Author author) {
		authorRepo.save(author);
		return "redirect:author";
	}

// Deleting current author
	@RequestMapping(path="/deleteauthor")
	public String getDeleteAuthor(@RequestParam("id") Integer id) {
		authorRepo.deleteById(id);
		return "redirect:author";
	}
	
}

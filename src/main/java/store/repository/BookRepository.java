package store.repository;

import org.springframework.data.repository.CrudRepository;

import store.domain.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}

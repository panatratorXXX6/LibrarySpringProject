package store.repository;


import org.springframework.data.repository.CrudRepository;

import store.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}

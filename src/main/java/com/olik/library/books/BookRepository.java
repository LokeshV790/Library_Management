package com.olik.library.books;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

	List<Book> findByAuthor(String author);

	List<Book> findByRentedFalse();

	List<Book> findByRentedTrue();
}

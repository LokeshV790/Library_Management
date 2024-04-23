package com.olik.library.rental;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentalRepository extends MongoRepository<Rental, String> {
	
	List<Rental> findByBookId(String bookId);

	List<Rental> findByBookIdAndReturnedFalse(String bookId);
	
}

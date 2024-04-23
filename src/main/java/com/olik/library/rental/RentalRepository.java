package com.olik.library.rental;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentalRepository extends MongoRepository<Rental, String> {
}

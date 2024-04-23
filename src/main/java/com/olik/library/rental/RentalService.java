package com.olik.library.rental;

import java.util.List;

public interface RentalService {

    Rental saveRental(Rental rental);

    Rental getRentalById(String id);

    List<Rental> getAllRentals();

    void deleteRental(String id);
    
    void returnBook(String id);
    
    List<Rental> getOverdueRentals();

	Rental createRental(Rental rental);
}

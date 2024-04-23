package com.olik.library.rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Rental saveRental(Rental rental) {
        // Set rental date to current date
        rental.setRentalDate(LocalDateTime.now());

        // Set return date to 14 days after rental date
        rental.setReturnDate(LocalDateTime.now().plusDays(14));

        return rentalRepository.save(rental);
    }

    @Override
    public Rental getRentalById(String id) {
        Optional<Rental> optionalRental = rentalRepository.findById(id);
        return optionalRental.orElse(null);
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public void deleteRental(String id) {
        rentalRepository.deleteById(id);
    }

    @Override
    public List<Rental> getOverdueRentals() {
        LocalDateTime currentDate = LocalDateTime.now();
        return rentalRepository.findAll().stream()
                .filter(rental -> rental.getReturnDate().isBefore(currentDate))
                .collect(Collectors.toList());
    }

    public Rental createRental(Rental rental) {
        // Check if the book is available for rent
        if (!isBookAvailableForRent(rental.getBookId())) {
            throw new RuntimeException("Book is already rented");
        }

        // Set rental date to current date
        rental.setRentalDate(LocalDateTime.now());

        // Set return date to 14 days after rental date
        rental.setReturnDate(rental.getRentalDate().plusDays(14));

        return rentalRepository.save(rental);
    }

    // Helper method to check if a book is available for rent
    private boolean isBookAvailableForRent(String bookId) {
        List<Rental> activeRentals = rentalRepository.findByBookIdAndReturnedFalse(bookId);
        return activeRentals.isEmpty();
    }


    @Override
    public void returnBook(String id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental not found"));

        // Mark the book as returned by updating the return date
        rental.setReturned(true);
        rentalRepository.save(rental);
    }
    
    // Helper method to check if a rental is overdue
    private boolean isRentalOverdue(Rental rental) {
        LocalDateTime currentDate = LocalDateTime.now();
        return rental.getReturnDate().isBefore(currentDate);
    }
}

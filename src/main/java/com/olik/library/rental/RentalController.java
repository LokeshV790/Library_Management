package com.olik.library.rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody Rental rental) {
        Rental createdRental = rentalService.saveRental(rental);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRental);
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable String id) {
        return rentalService.getRentalById(id);
    }

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PutMapping("/return/{id}")
    public void returnBook(@PathVariable String id) {
        rentalService.returnBook(id);
    }
}

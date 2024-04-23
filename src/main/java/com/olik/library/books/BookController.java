package com.olik.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok().body(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/available")
    public List<Book> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    @GetMapping("/rented")
    public List<Book> getRentedBooks() {
        return bookService.getRentedBooks();
    }
}

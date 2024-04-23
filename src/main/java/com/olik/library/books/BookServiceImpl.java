package com.olik.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(String id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(String id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> getAvailableBooks() {
        return bookRepository.findByRentedFalse();
    }

    @Override
    public List<Book> getRentedBooks() {
        return bookRepository.findByRentedTrue();
    }
}

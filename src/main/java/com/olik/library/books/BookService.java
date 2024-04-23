package com.olik.library.books;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    Book getBookById(String id);

    List<Book> getAllBooks();

    Book updateBook(String id, Book book);

    void deleteBook(String id);
}

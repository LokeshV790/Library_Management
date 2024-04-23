package com.olik.library.author;

import java.util.List;

public interface AuthorService {

    Author createAuthor(Author author);

    Author getAuthorById(String id);

    List<Author> getAllAuthors();

    Author updateAuthor(String id, Author author);

    void deleteAuthor(String id);
}
package com.olik.library.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(String id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        return optionalAuthor.orElse(null);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(String id, Author author) {
        if (authorRepository.existsById(id)) {
            author.setId(id);
            return authorRepository.save(author);
        }
        return null;
    }

    @Override
    public void deleteAuthor(String id) {
        authorRepository.deleteById(id);
    }
}

// BookRequest.java
package com.olik.library.books;

public class BookRequest {

    public String title;
    public String author;
    public String isbn;
    public int publicationYear;

    // Constructors, getters, and setters

    public Book toBook() {
        Book book = new Book();
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setIsbn(this.isbn);
        book.setPublicationYear(this.publicationYear);
        return book;
    }
}

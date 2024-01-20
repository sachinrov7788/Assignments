package com.example.onlinebookstore.service;

import org.springframework.http.ResponseEntity;

import com.example.onlinebookstore.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(String bookId);

    Book createBook(Book newBook);

    Book updateBook(String bookId, Book updatedBook);

    String deleteBook(String bookId);

    List<Book> bookAuthorId(String bookId);
}


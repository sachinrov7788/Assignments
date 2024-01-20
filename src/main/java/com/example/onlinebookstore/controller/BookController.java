package com.example.onlinebookstore.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinebookstore.model.Author;
import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    // @GetMapping("/{bookId}")
    // public ResponseEntity<Book> getBookById(@PathVariable String bookId) {
    //     Book book = bookService.getBookById(bookId);
    //     return new ResponseEntity<>(book, HttpStatus.OK);
    // }

    @GetMapping("/{bookId}")
    public ResponseEntity<List<Book>> getBookByIdAuthor(@PathVariable String bookId) {
        return new ResponseEntity<>(bookService.bookAuthorId(bookId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book newBook) {
        Book book = bookService.createBook(newBook);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable String bookId, @RequestBody Book updatedBook) {
        Book book = bookService.updateBook(bookId, updatedBook);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId) {
        String book = bookService.deleteBook(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}

package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.model.Author;
import com.example.onlinebookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable String authorId) {
        Author author = authorService.getAuthorById(authorId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author newAuthor) {
        Author author = authorService.createAuthor(newAuthor);
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Author> updateAuthor(@PathVariable String authorId, @RequestBody Author updatedAuthor) {
        Author author = authorService.updateAuthor(authorId,updatedAuthor);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable String authorId) {
        String author = authorService.deleteAuthor(authorId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}

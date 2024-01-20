package com.example.onlinebookstore.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.onlinebookstore.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

    Book findByBookId(String bookId);

    Boolean existsByBookId(String bookId);

    String deleteByBookId(String bookId);

    List<Book> findByAuthorId(String authorId);  

}

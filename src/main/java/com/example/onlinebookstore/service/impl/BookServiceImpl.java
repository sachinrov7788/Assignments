package com.example.onlinebookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.onlinebookstore.model.Book;
import com.example.onlinebookstore.repository.AuthorRepository;
import com.example.onlinebookstore.repository.BookRepository;
import com.example.onlinebookstore.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Book> getAllBooks() {
        try {
            List<Book> books = bookRepository.findAll();
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Book getBookById(String bookId) {
        try{
        Book optionalBook = bookRepository.findById(bookId).orElse(null);
        return optionalBook;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Book createBook(Book newBook) {
        try {
            Book existingBook = bookRepository.findByBookId(newBook.getBookId());
            
            if(existingBook==null){
                bookRepository.save(newBook);
                return newBook;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Book updateBook(String bookId, Book updatedBook) {
        try {
            Book existingBook = bookRepository.findByBookId(bookId);

            if(existingBook!=null){
                updatedBook.setBookId(existingBook.getBookId());
                bookRepository.save(updatedBook);
                return updatedBook;
            }
            else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteBook(String bookId) {
        try{
            Boolean existingBook = bookRepository.existsByBookId(bookId);

            if(existingBook){
                bookRepository.deleteByBookId(bookId);
                return "Deleted Successfully";
            }
            else{
                return "BookId not found give valid bookId";
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Book> bookAuthorId(String bookId){
        Book listBook = bookRepository.findByBookId(bookId);
        String authorId = listBook.getAuthorId();
        return bookRepository.findByAuthorId(authorId);
    }
}
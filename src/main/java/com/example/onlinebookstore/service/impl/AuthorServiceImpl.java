package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.model.Author;
import com.example.onlinebookstore.repository.AuthorRepository;
import com.example.onlinebookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        try {
            List<Author> authors = authorRepository.findAll();
            return authors;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Author getAuthorById(String authorId) {
        try {
        Author optionalAuthor = authorRepository.findById(authorId).orElse(null);
        return optionalAuthor;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Author createAuthor(Author newAuthor) {
        try {
            Author existingAuthor;
            existingAuthor = authorRepository.findByAuthorId(newAuthor.getAuthorId());
            
            if(existingAuthor==null){
                authorRepository.save(newAuthor);
                return newAuthor;
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
    public Author updateAuthor(String authorId, Author updatedAuthor) {
        try {
            Author existingAuthor = authorRepository.findByAuthorId(authorId);
            
            if(existingAuthor!=null){
                updatedAuthor.setAuthorId(existingAuthor.getAuthorId());
                authorRepository.save(updatedAuthor);
                return updatedAuthor;
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
    public String deleteAuthor(String authorId) {
        try {
            Boolean existingAuthor = authorRepository.existsByAuthorId(authorId);
            
            if(existingAuthor){
                authorRepository.deleteByAuthorId(authorId);
                return "Deleted Successfully";
            }

            else{
                return "AuthorId not found give valid authorId";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
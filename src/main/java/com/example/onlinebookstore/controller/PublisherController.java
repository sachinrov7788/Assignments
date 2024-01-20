package com.example.onlinebookstore.controller;

import com.example.onlinebookstore.model.Author;
import com.example.onlinebookstore.model.Publisher;
import com.example.onlinebookstore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publishers = publisherService.getAllPublishers();
        return new ResponseEntity<List<Publisher>>(publishers, HttpStatus.OK);
    }

    @GetMapping("/{publisherId}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable String publisherId) {
        Publisher publisher = publisherService.getPublisherById(publisherId);
        return new ResponseEntity<>(publisher, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher newPublisher) {
        Publisher publisher = publisherService.createPublisher(newPublisher);
        return new ResponseEntity<>(publisher, HttpStatus.CREATED);
    }

    @PutMapping("/{publisherId}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable String publisherId, @RequestBody Publisher updatedPublisher) {
        Publisher publisher = publisherService.updatePublisher(publisherId,updatedPublisher);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    @DeleteMapping("/{publisherId}")
    public ResponseEntity<String> deletePublisher(@PathVariable String publisherId) {
        String publisher = publisherService.deletePublisher(publisherId);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }
}

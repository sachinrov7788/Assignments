package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.model.Author;
import com.example.onlinebookstore.model.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PublisherRepository extends MongoRepository<Publisher, String> {

    Publisher findByPublisherId(String publisherId);

    String deleteByPublisherId(String publisherId);

    Boolean existsByPublisherId(String publisherId);

}

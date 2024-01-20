package com.example.onlinebookstore.service.impl;

import com.example.onlinebookstore.model.Author;
import com.example.onlinebookstore.model.Publisher;
import com.example.onlinebookstore.repository.PublisherRepository;
import com.example.onlinebookstore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublishers() {
        try {
            List<Publisher> publishers = publisherRepository.findAll();
            return publishers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Publisher getPublisherById(String publisherId) {
        try {
            Publisher optionalPublisher = publisherRepository.findById(publisherId).orElse(null);
            return optionalPublisher;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
    }

    @Override
    public Publisher createPublisher(Publisher newPublisher) {
        try {
            Publisher existingPublisher;
            existingPublisher = publisherRepository.findByPublisherId(newPublisher.getPublisherId());
            
            if(existingPublisher==null){
                publisherRepository.save(newPublisher);
                return newPublisher;
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
    public Publisher updatePublisher(String publisherId, Publisher updatedPublisher) {
        try {
            Publisher existingPublisher = publisherRepository.findByPublisherId(publisherId);
            
            if(existingPublisher!=null){
                updatedPublisher.setPublisherId(existingPublisher.getPublisherId());
                publisherRepository.save(updatedPublisher);
                return updatedPublisher;
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
    public String deletePublisher(String publisherId) {
        try {
            Boolean existingPublisher = publisherRepository.existsByPublisherId(publisherId);
            
            if(existingPublisher){
                publisherRepository.deleteByPublisherId(publisherId);
                return "Deleted Successfully";
            }

            else{
                return "PublisherId not found give valid publisherId";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.example.Springboot.trustrace.dao.impl;

import com.example.Springboot.trustrace.dao.DaoInterface;
import com.example.Springboot.trustrace.model.Facilities;
import com.example.Springboot.trustrace.model.Style;
import com.example.Springboot.trustrace.model.Suppliers;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoImplementation implements DaoInterface {

    MongoTemplate template;

    public DaoImplementation(MongoTemplate template) {
        this.template = template;
    }

    public List<Style> getAllData() {
        return template.findAll(Style.class);
    }

    public void supplierNameUpdate(String oldName, String newName) {

        Criteria criteria = Criteria.where("supplier_name").is(oldName);
        Query query = new Query(criteria);

        Update update = new Update().set("supplier_name", newName);

        template.updateFirst(query, update, Suppliers.class);

        supplierNameUpdateInstyle(oldName, newName);
    }

    public void supplierNameUpdateInstyle(String oldName, String newName) {

        Criteria criteria = Criteria.where("supplier_name").is(oldName);
        Query query = new Query(criteria);

        Update update = new Update().set("supplier_name", newName);

        template.updateFirst(query, update, Style.class);
    }

    public void facilityNameUpdate(String oldName, String newName) {

        Criteria criteria = Criteria.where("facility_name").is(oldName);
        Query query = new Query(criteria);

        Update update = new Update().set("facility_name", newName);

        template.updateFirst(query, update, Facilities.class);

        facilityNameUpdateInstyle(oldName, newName);
    }

    public void facilityNameUpdateInstyle(String oldName, String newName) {

        Criteria criteria = Criteria.where("facility_name").is(oldName);
        Query query = new Query(criteria);

        Update update = new Update().set("facility_name", newName);

        template.updateFirst(query, update, Style.class);
    }

    public void deleteStyle(long id) {

        Criteria criteria = Criteria.where("_id").is(id);
        Query query = new Query(criteria);
        template.remove(query, Style.class);
    }
}
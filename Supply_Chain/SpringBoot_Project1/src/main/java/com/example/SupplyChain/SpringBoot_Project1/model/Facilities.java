package com.example.SupplyChain.SpringBoot_Project1.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection="facilities")
@Data
public class Facilities {
    @Id
    private String id;

    private List<String> certifications;

    @Field("created_by")
    private String createdBy;

    @Field("facility_name")
    private String facilityName;

    private String location;
    private String material;

    @Field("supplier_uid")
    @DocumentReference(collection="suppliers")
    private Suppliers supplierUid;

}
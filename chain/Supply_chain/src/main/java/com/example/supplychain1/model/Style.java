package com.example.supplychain1.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection="style")
@Data
public class Style {
    @Id
    private String _id;
    public Availability availability;

    @Field("facility_name")
    private String facilityName;

    @Field("material_composition")
    private ArrayList<Material> materialComposition;

    @Field("required_certificate")
    private String requiredCertificate;

    private String season;

    @Field("style_name")
    private String styleName;

    @Field("style_number")
    private String styleNumber;

    @Field("style_uid")
    private String styleUid;

    @Field("supplier_name")
    private String supplierName;

    private String type;
    private String year;


    @Data
    public static class Availability{
        private String amount;
    }
}


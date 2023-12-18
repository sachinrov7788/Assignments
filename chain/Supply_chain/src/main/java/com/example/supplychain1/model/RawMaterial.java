package com.example.supplychain1.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection="material")
@Data
public class RawMaterial {
    @Id
    private String _id;

    private Availability availability;
    @Data
    public static class Availability{
        private String amount;
    }

    @Field("material_number")
    private String materialNumber;

    private String name;
    private String number;

    @Field("required_certificate")
    private ArrayList<String> requiredCertificate;

    private String season;

    @Field("supplier_id")
    @DocumentReference(collection="suppliers")
    private Suppliers supplierId;

    @Field("supplier_material_name")
    private String supplierMaterialName;

    @Field("facilities_uid")
    @DocumentReference(collection="facilities")
    private ArrayList<Facilities> facilitiesUid;

    @Field("material_composition")
    private ArrayList<String> materialComposition;

    @Field("material_uid")
    private String materialUid;

    @Field("RM_supplier_name")
    private String rmSupplierName;

    private String type;
    private String year;

}

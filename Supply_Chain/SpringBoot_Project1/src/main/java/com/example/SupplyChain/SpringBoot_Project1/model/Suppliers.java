package com.example.SupplyChain.SpringBoot_Project1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suppliers {
    @Id
    private String _id;

    @Field("email_id")
    private String emailId;

    private String facilities;
    private Location location;

    @Field("material_type")
    private String materialType;

    @Field("raw_material")
    private String rawMaterial;

    private String styles;

    @Field("supplier_name")
    private String supplierName;

    @Field("supplier_uid")
    private String supplierUid;
    private String tier;

}
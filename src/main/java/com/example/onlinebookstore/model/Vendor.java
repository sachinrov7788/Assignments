package com.example.onlinebookstore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("vendors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vendor {
    
    private String vendorId;
    private String storeName;
    private String contactInformation;
}

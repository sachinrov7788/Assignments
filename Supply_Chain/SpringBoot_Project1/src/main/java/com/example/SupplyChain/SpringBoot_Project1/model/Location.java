package com.example.SupplyChain.SpringBoot_Project1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String address;
    private String country;
    private String pincode;
    private String region;
    private String state;
}

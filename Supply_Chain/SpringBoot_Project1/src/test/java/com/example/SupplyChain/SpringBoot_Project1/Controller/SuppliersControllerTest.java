package com.example.SupplyChain.SpringBoot_Project1.Controller;

import com.example.SupplyChain.SpringBoot_Project1.controller.SuppliersController;
import com.example.SupplyChain.SpringBoot_Project1.model.Location;
import com.example.SupplyChain.SpringBoot_Project1.model.Suppliers;
import com.example.SupplyChain.SpringBoot_Project1.service.SuppliersService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebMvcTest(value = SuppliersController.class)
public class SuppliersControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    @SpyBean
    SuppliersService service;

    @Test
    void SupplierGetAllData() throws Exception {
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(service.getAllData()).thenReturn(Arrays.asList(newSuppliers));
        String result=mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/alldata"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");

        ArrayList op = new ObjectMapper().readValue(result, ArrayList.class);
        assertFalse(op.equals(null));
    }

    @Test
    void testGetByIdWorks() throws Exception {
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(newSuppliers));
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/databyid/cd")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("_____________________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Suppliers op = new ObjectMapper().readValue(result, Suppliers.class);
        assertFalse(op.equals(null));
    }

    @Test
    void testGetByIdNotWorks() throws Exception {
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(service.getById("id")).thenThrow(RuntimeException.class);
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/databyid/id"))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(new Suppliers())))
                .andReturn().getResponse().getContentAsString();
        System.out.println("_____________________________");
        System.out.println(result);
        System.out.println("_____________________________");

        Suppliers op = new ObjectMapper().readValue(result, Suppliers.class);
        assertTrue(op.equals(new Suppliers()));
    }



    @Test
    public void testInsertWorks() throws Exception{
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(service.insert(Mockito.any(Suppliers.class))).thenReturn(newSuppliers);
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/suppliers/insert").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(newSuppliers))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");
        Suppliers actualOutput = new ObjectMapper().readValue(result, Suppliers.class);
        assertThat(actualOutput).isEqualTo(newSuppliers);
    }

    @Test
    public void testInsertNotWorks() throws Exception{
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(service.insert(newSuppliers)).thenThrow(RuntimeException.class);
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/suppliers/insert").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(newSuppliers))).andExpect(status().isBadRequest()).andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(new Suppliers())))
                .andReturn().getResponse().getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");
        Suppliers actualOutput = new ObjectMapper().readValue(result, Suppliers.class);
        assertThat(actualOutput).isEqualTo(new Suppliers());
    }

    @Test
    public void testUpdateWorks() throws Exception{
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(service.update(Mockito.any(Suppliers.class))).thenReturn(newSuppliers);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/suppliers/update").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(newSuppliers))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");
        Suppliers actualOutput = new ObjectMapper().readValue(result, Suppliers.class);
        assertThat(actualOutput).isEqualTo(newSuppliers);
    }

    @Test
    public void testUpdateNotWorks() throws Exception{
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(service.update(newSuppliers)).thenThrow(RuntimeException.class);
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/suppliers/update").contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(newSuppliers))).andExpect(status().isBadRequest()).andExpect(MockMvcResultMatchers.content().string(new ObjectMapper().writeValueAsString(new Suppliers())))
                .andReturn().getResponse().getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");
        Suppliers actualOutput = new ObjectMapper().readValue(result, Suppliers.class);
        assertThat(actualOutput).isEqualTo(new Suppliers());
    }

    @Test
    void testDeleteWorks() throws Exception {
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(Optional.of(newSuppliers));
        Mockito.when(service.delete("cd")).thenReturn(true);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/suppliers/delete/cd")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");

        Boolean op = new ObjectMapper().readValue(result, Boolean.class);
        assertEquals(true,op);
    }

    @Test
    void testDeleteNotWorks() throws Exception {
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(service.getById("cd")).thenReturn(Optional.of(newSuppliers));
        Mockito.when(service.delete("id")).thenThrow(RuntimeException.class);
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/suppliers/delete/id"))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse()
                .getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");

        Boolean op = new ObjectMapper().readValue(result, Boolean.class);
        assertEquals(false,op);
    }
}

package com.example.SupplyChain.SpringBoot_Project1.Service;

import com.example.SupplyChain.SpringBoot_Project1.model.Location;
import com.example.SupplyChain.SpringBoot_Project1.model.Suppliers;
import com.example.SupplyChain.SpringBoot_Project1.repository.SuppliersRepository;
import com.example.SupplyChain.SpringBoot_Project1.service.impl.SuppliersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class SuppliersServiceTest {
    @Mock
    private SuppliersRepository repo;

    @InjectMocks
    private SuppliersServiceImpl service;

    @Test
    public void testThatFacilityCanbeCreated() throws Exception{
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(repo.save(newSuppliers)).thenReturn(newSuppliers);
        Suppliers result = service.insert(newSuppliers);
        assertEquals(newSuppliers, result);
    }

    @Test
    public void testThatFacilityCanNotbeCreated() throws Exception{
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(repo.save(newSuppliers)).thenThrow(RuntimeException.class);
        Suppliers result = service.insert(newSuppliers);
        assertNotEquals(newSuppliers, result);
    }

    @Test
    public void testThatFacilityCanGetById() throws Exception {
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(repo.findById("cd")).thenReturn(Optional.of(newSuppliers));
        Optional<Suppliers> result=service.getById("cd");
        assertEquals(Optional.of(newSuppliers),result);
    }

    @Test
    public void testThatFacilityCanNotGetById() throws Exception {
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(repo.findById("snffdk")).thenThrow(RuntimeException.class);
        Optional<Suppliers> result=service.getById("snffdk");
        assertNotEquals(Optional.of(newSuppliers),result);
    }

    @Test
    public void testThatFacilityCanUpdate() throws Exception {
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(repo.save(newSuppliers)).thenReturn(newSuppliers);
        Suppliers result = service.update(newSuppliers);
        assertEquals(newSuppliers, result);
    }

    @Test
    public void testThatFacilityCanNotUpdate() throws Exception {
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(repo.save(newSuppliers)).thenThrow(RuntimeException.class);
        Suppliers result = service.update(newSuppliers);
        assertNotEquals(newSuppliers, result);
    }

    @Test
    public void testThatFacilityCanDeleteById() throws Exception {
        Suppliers newSuppliers = new Suppliers("cd", "emailid", "facilities", new Location("adrress", "country", "pincode", "region", "state"), "material_type", "raw_material", "styles", "supplier_name", "supplier_uid", "tier", "imagefile_path");
        Mockito.when(repo.delete("cd")).thenReturn(true);
        service.delete("cd");
        Mockito.verify(repo, Mockito.times(1)).delete("cd");
    }
}

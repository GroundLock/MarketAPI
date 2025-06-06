package com.example.MarketAPI.service;

import com.example.MarketAPI.model.Product;
import com.example.MarketAPI.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void testCreateProduct() {
        Product input = new Product(null, "img.jpg", "Milk", 3.5, 10, "BrandX");
        Product saved = new Product(1L, "img.jpg", "Milk", 3.5, 10, "BrandX");
        when(repository.save(input)).thenReturn(saved);
        Product result = service.create(input);
        assertEquals(1L, result.getId());
        assertEquals("Milk", result.getName());
    }

    @Test
    void testGetAllProducts(){
        List<Product> mockList = List.of(
                new Product(1L, "img1.jpg", "Milk", 3.5, 10, "BrandX"),
                new Product(2L, "img2.jpg", "Water", 0.5, 10, "BrandX")
        );
        when(repository.findAll()).thenReturn(mockList);

        List<Product> result = service.getAll();
        assertEquals(2, result.size());
        assertEquals("Milk", result.get(0).getName());
    }

    @Test
    void testGetIdProduct(){
        Product mockProduct = new Product(1L, "img.jpg", "Milk", 3.5, 10, "BrandX");
        when(repository.findById(1L)).thenReturn(Optional.of(mockProduct));
        Product result = service.getId(1L);
        assertEquals(1, result.getId());
        assertEquals("Milk", result.getName());
    }

    @Test
    void testUpdate(){
        Long id = 1L;
        Product productToUpdate = new Product(null, "img.jpg", "Milk", 3.5, 10, "BrandX");
        Product updatedProduct = new Product(id, "img.jpg", "Milk", 3.5, 10, "BrandX");

        when(repository.findById(id)).thenReturn(Optional.of(updatedProduct));
        when(repository.save(any(Product.class))).thenReturn(updatedProduct);

        Product result = service.update(1L, productToUpdate);

        assertNotNull(result);
        assertEquals("Milk", result.getName());
    }

    @Test
    void testDelete() {
        Long id = 1L;
        doNothing().when(repository).deleteById(id);
        service.delete(id);
        verify(repository, times(1)).deleteById(id);
    }
}
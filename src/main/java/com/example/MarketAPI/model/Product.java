package com.example.MarketAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "TB_PRODUCTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_img")
    @URL
    private String img;
    @Column(name="product_name")
    @NotBlank
    private String name;
    @Column(name = "product_price")
    @Positive
    private double price;
    @Column(name = "product_stock")
    @Min(0)
    private int stock;
    @Column(name = "product_brand")
    @NotBlank
    private String brand;
}

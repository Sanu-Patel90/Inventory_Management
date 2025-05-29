package com.InventoryManagement.InventoryManagement.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;

    // Constructors
    public Product() {}
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    public void setName(String name) { this.name = name; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

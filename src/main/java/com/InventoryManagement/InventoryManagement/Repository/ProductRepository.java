package com.InventoryManagement.InventoryManagement.Repository;

import com.InventoryManagement.InventoryManagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}


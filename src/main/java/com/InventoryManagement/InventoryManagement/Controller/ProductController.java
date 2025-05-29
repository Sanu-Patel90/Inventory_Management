package com.InventoryManagement.InventoryManagement.Controller;


import com.InventoryManagement.InventoryManagement.Repository.ProductRepository;
import com.InventoryManagement.InventoryManagement.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        // Step 2: Check if the product exists
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get(); // Get the existing product

            // Step 3: Update the quantity
            existingProduct.setQuantity(updatedProduct.getQuantity());

            // Step 4: Save the updated product back to the database
            return productRepository.save(existingProduct);
        } else {
            // Step 5: If product is not found, throw an error
            throw new RuntimeException("Product not found with ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "Product deleted";
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
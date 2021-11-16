package com.T3H.Project_1.repository;

import com.T3H.Project_1.entity.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getAllProducts();
    public Product getById(int id);
    public Product getByName(String productName);
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(Product product);
}

package com.T3H.Project_1.service;

import com.T3H.Project_1.entity.Product;
import com.T3H.Project_1.model.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> getAllProducts();
    public ProductDTO getById(int id);
    public ProductDTO getByName(String productName);
    public void addProduct(ProductDTO productDTO);
    public void updateProduct(ProductDTO productDTO);
    public void deleteProduct(ProductDTO productDTO);
}

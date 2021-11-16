package com.T3H.Project_1.service.impl;

import com.T3H.Project_1.entity.Product;
import com.T3H.Project_1.model.ProductDTO;
import com.T3H.Project_1.repository.ProductRepository;
import com.T3H.Project_1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.getAllProducts();
        List<ProductDTO> productDTOS = new ArrayList<ProductDTO>();
        for(Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setProductName(product.getProductName());
            productDTO.setPrice(product.getPrice());
            productDTO.setDesc(product.getDesc());

            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    @Override
    public ProductDTO getById(int id) {
        Product product = productRepository.getById(id);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
            productDTO.setProductName(product.getProductName());
            productDTO.setPrice(product.getPrice());
            productDTO.setDesc(product.getDesc());

        return productDTO;
    }

    @Override
    public ProductDTO getByName(String productName) {
        Product product = productRepository.getByName(productName);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDesc(product.getDesc());

        return productDTO;
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setDesc(productDTO.getDesc());

        productRepository.addProduct(product);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Product product = productRepository.getById(productDTO.getId());
        if(product != null) {
            product.setProductName(productDTO.getProductName());
            product.setPrice(productDTO.getPrice());
            product.setDesc(productDTO.getDesc());
            productRepository.updateProduct(product);
        }
    }

    @Override
    public void deleteProduct(ProductDTO productDTO) {
        Product product = productRepository.getById(productDTO.getId());
        if(product != null) productRepository.deleteProduct(product);
    }
}

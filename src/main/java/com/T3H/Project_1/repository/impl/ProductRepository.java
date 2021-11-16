package com.T3H.Project_1.repository.impl;

import com.T3H.Project_1.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements com.T3H.Project_1.repository.ProductRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> getAllProducts() {
        String jql = "SELECT p FROM Product p";
        return entityManager.createQuery(jql, Product.class).getResultList();
    }

    @Override
    public Product getById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product getByName(String productName) {
        String jql = "SELECT p FROM Product p WHERE p.productName = ?1";
        return entityManager.createQuery(jql, Product.class).setParameter(1, productName).getSingleResult();
    }

    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void deleteProduct(Product product) {
        entityManager.remove(product);
    }
}

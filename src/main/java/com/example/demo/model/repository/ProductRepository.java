package com.example.demo.model.repository;

import com.example.demo.model.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepository {
    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM products", Product.class).getResultList();
    }

    public boolean deleteById(Long id) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        int result = entityManager.createNativeQuery("DELETE FROM products WHERE id = " + id).executeUpdate();
        transaction.commit();
        return result > 0;
    }

    public void save(Product product) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();
    }

    public void update(Product product) {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Product uProduct = entityManager.find(Product.class, product.getId());
        uProduct.setTitle(product.getTitle());
        uProduct.setPrice(product.getPrice());
        transaction.commit();
    }

}

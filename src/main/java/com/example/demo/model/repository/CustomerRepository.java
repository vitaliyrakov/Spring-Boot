package com.example.demo.model.repository;

import com.example.demo.model.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerRepository {
    private final EntityManager entityManager;

    public CustomerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM customers", Customer.class).getResultList();
    }

}

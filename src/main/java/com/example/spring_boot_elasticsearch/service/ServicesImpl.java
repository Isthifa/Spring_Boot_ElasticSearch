package com.example.spring_boot_elasticsearch.service;

import com.example.spring_boot_elasticsearch.entity.Products;
import com.example.spring_boot_elasticsearch.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesImpl implements Services{

    private final ProductsRepo repo;

    @Autowired
    public ServicesImpl(ProductsRepo repo) {
        this.repo = repo;
    }

    @Override
    public Iterable<Products> findall() {
        return repo.findAll();
    }

    @Override
    public Products insert(Products products) {
        return repo.save(products);
    }

    @Override
    public Products update(Products products, int id) {
        Products products1=repo.findById(id).get();
        products1.setPrice(products.getPrice());
        return products1;
    }

    @Override
    public void deleteById(int id) {

        repo.deleteById(id);

    }
}

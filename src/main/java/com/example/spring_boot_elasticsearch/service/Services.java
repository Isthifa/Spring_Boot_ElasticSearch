package com.example.spring_boot_elasticsearch.service;

import com.example.spring_boot_elasticsearch.entity.Products;

public interface Services {

    Iterable<Products> findall();

    Products insert(Products products);

    Products update(Products products,int id);

    void deleteById(int id);
}

package com.example.spring_boot_elasticsearch.repository;

import com.example.spring_boot_elasticsearch.entity.Products;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends ElasticsearchRepository<Products,Integer> {
}

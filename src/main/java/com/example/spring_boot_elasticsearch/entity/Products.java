package com.example.spring_boot_elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Products {

    private int id;
    private String name;
    private String description;
    private int quantity;

    private double price;
}

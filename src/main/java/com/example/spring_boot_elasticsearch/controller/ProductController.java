package com.example.spring_boot_elasticsearch.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.spring_boot_elasticsearch.entity.Products;
import com.example.spring_boot_elasticsearch.service.ElasticSearchService;
import com.example.spring_boot_elasticsearch.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class ProductController {
    private final Services services;
    private final ElasticSearchService elasticSearchService;

    @Autowired
    public ProductController(Services services, ElasticSearchService elasticSearchService) {
        this.services = services;
        this.elasticSearchService = elasticSearchService;
    }

    @PostMapping("/save")
    public Products save(@RequestBody Products products) {
        return services.insert(products);
    }

    @GetMapping("/findall")
    public Iterable<Products> productsList() {
        return services.findall();
    }

    @GetMapping("/matchall")
    public String matchAll() throws IOException {
        SearchResponse<Map> searchResponse = elasticSearchService.matchAllQuery();
        return searchResponse.hits().hits().toString();
    }

    @GetMapping("/matchallproducts")
    public List<Products> productsLis() throws IOException {
        SearchResponse<Products> productsSearchResponse = elasticSearchService.matchAllProductServices();
        return getProductsList(productsSearchResponse);
    }

    @GetMapping("/matchproductsfield/{fieldname}")
    public List<Products> matchallwithproductfield(@PathVariable String fieldname) throws IOException {
        SearchResponse<Products> productsSearchResponse = elasticSearchService.matchProductsWithName(  fieldname);
        return getProductsList(productsSearchResponse);
    }

    private List<Products> getProductsList(SearchResponse<Products> productsSearchResponse) {
        List<Hit<Products>> hitLis = productsSearchResponse.hits().hits();
        List<Products> productsLis = new ArrayList<>();
        for (Hit<Products> hits : hitLis) {
            productsLis.add(hits.source());
        }
        return productsLis;
    }
}

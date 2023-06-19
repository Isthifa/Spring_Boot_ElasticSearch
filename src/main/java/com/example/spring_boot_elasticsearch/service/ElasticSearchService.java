package com.example.spring_boot_elasticsearch.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.spring_boot_elasticsearch.entity.Products;
import com.example.spring_boot_elasticsearch.util.ElasticSearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class ElasticSearchService {

    private final ElasticsearchClient client;

    @Autowired
    public ElasticSearchService(ElasticsearchClient client) {
        this.client = client;
    }

    public SearchResponse<Map> matchAllQuery() throws IOException {
        Supplier<Query> supplier= ElasticSearchUtil.supplier();
        SearchResponse<Map> searchResponse=client.search(s->s.query(supplier.get()), Map.class);
        System.out.println(supplier.get().toString());
        return searchResponse;
    }
    public SearchResponse<Products> matchAllProductServices() throws IOException {
        Supplier<Query> supplier= ElasticSearchUtil.supplier();
        SearchResponse<Products> searchResponse=client.search(s->s.index("products").query(supplier.get()), Products.class);
        System.out.println(supplier.get().toString());
        return searchResponse;
    }

    public SearchResponse<Products> matchProductsWithName(String fieldValue) throws IOException {
        Supplier<Query> supplier  = ElasticSearchUtil.supplierWithNameField(fieldValue);
        SearchResponse<Products> searchResponse = client.search(s->s.index("products").query(supplier.get()),Products.class);
        System.out.println("elasticsearch query is "+supplier.get().toString());
        return searchResponse;
    }
}

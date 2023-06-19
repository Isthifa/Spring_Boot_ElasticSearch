//package com.example.spring_boot_elasticsearch.config;
//
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
//import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
//
//@Configuration
//public class ElasticConfig extends AbstractElasticsearchConfiguration {
//
//    @Bean
//    @Override
//    public RestHighLevelClient elasticsearchClient() {
//        ClientConfiguration configuration=ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .build();
//        return RestClients.create(configuration).rest();
//
//    }
//}

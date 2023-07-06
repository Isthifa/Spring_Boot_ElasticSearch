package com.example.spring_boot_elasticsearch.util;

import co.elastic.clients.elasticsearch._types.query_dsl.FuzzyQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;

import java.util.function.Supplier;


public class ElasticSearchUtil {

    private static MatchAllQuery.Builder matchQuery;

    public static Supplier<Query> supplier()
    {
        Supplier<Query> supplier=()->Query.of(q-> q.matchAll(matchAllQuery()));
        return supplier;
    }

    public static MatchAllQuery matchAllQuery()
    {
        val matchAllquery=new MatchAllQuery.Builder();
        return matchAllquery.build();
    }

    public static Supplier<Query> supplierWithNameField(String fieldValue)
    {
        Supplier<Query> supplier=()->Query.of(q-> q.match(MatchWithFieldName(fieldValue)));
        return supplier;
    }

    public static MatchQuery MatchWithFieldName(String fieldname)
    {
        val matchQuery = new MatchQuery.Builder();
        return matchQuery.field("name").query(fieldname).build();
    }

    //fuzzy query
    public static Supplier<Query> createQuery(String fieldValue)
    {
        Supplier<Query> supplier=()->Query.of(q-> q.fuzzy(createFuzzyQuery(fieldValue)));
        return supplier;
    }
    public static FuzzyQuery createFuzzyQuery(String fieldValue)
    {
        val fuzzyQuery=new FuzzyQuery.Builder();
        return fuzzyQuery.field("name").value(fieldValue).build();
    }

    //fuzzy query with fuzziness



}

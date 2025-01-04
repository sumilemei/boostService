package com.taoz.boost.iss.service;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author taozheng
 * @create 2023-12-09 2:31 下午
 * @introduce:
 */
@Service
public class EsSeniorService {

    @Resource
    private RestHighLevelClient client;

    public String matchAll(){
        return "";
    }

    /**
     * 请筛选出位于上海价格在310-390，且评分不低于40分的万怡和豪生酒店
     */
    public void boolSearch(){
        SearchRequest searchRequest = new SearchRequest("hotel");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.termQuery("city","上海"));
        boolQueryBuilder.should(QueryBuilders.termsQuery("brand","万怡","豪生"));
        boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(310).lte(390));
        boolQueryBuilder.mustNot(QueryBuilders.rangeQuery("score").lt(40));
        searchRequest.source().query(boolQueryBuilder);
        try {
            SearchResponse searchResponse = client.search(searchRequest,RequestOptions.DEFAULT);
            System.out.println(searchResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

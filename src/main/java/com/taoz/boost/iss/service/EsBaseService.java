package com.taoz.boost.iss.service;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Marker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author taozheng
 * @create 2023-11-12 1:48 下午
 * @introduce:
 */
@Service
@Slf4j
public class EsBaseService {

    @Resource
    private RestHighLevelClient client;

    public void createIndex(String indexName,String mappings) {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        createIndexRequest.source(mappings, XContentType.JSON);
        try {
            client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.taoz.boost.iss.service;

import com.alibaba.fastjson.JSON;
import com.taoz.boost.iss.dao.HelloDao;
import com.taoz.boost.iss.entity.Hotel;
import com.taoz.boost.iss.entity.HotelDoc;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
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
    @Resource
    private HelloDao hotelDao;

    public void createIndex(String indexName,String mappings) {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
        createIndexRequest.source(mappings, XContentType.JSON);
        try {
            client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteIndex(String indexName){
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);
        try {
            client.indices().delete(deleteIndexRequest,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String existIndex(String indexName){
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
        try {
            boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
            return Boolean.TRUE.equals(exists) ? "存在" : "不存在该索引";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "-1";
    }

    public void addDocument(){
        Hotel byId = hotelDao.getHotelInfo(61075L);
        HotelDoc hotelDoc = new HotelDoc(byId);
        IndexRequest indexRequest = new IndexRequest("hotel").id(hotelDoc.getId().toString());
        indexRequest.source(JSON.toJSONString(hotelDoc),XContentType.JSON);
        try {
            client.index(indexRequest,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDocument(){
        GetRequest request = new GetRequest("hotel","61075");
        GetResponse documentFields = null;
        try {
            documentFields = client.get(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String document = documentFields.getSourceAsString();
        return document;
    }
}

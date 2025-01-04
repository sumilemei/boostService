package com.taoz.boost.iss.service;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
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
    private HelloDao hotel2Dao;

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

    }

    public String getDocument(){
        return "";
    }

    public void updateDocument(){

    }

    public void deleteDocument(){

    }

    /**
     * 批量插入文档
     */
    public void bulkAddDocument(){

    }

    /**
     * deleteByQuery :根据条件删除文档数据
     * deleteByQuery删除原理：
     * Delete_by_query并不是真正意义上物理文档删除，而是只是版本变化并且对文档增加了删除标记。
     * 当我们再次搜索的时候，会搜索全部然后过滤掉有删除标记的文档。
     * 因此，该索引所占的空间并不会随着该API的操作磁盘空间会马上释放掉，只有等到下一次段合并的时候才真正被物理删除，这个时候磁盘空间才会释放。
     * 相反，在被查询到的文档标记删除过程同样需要占用磁盘空间，这个时候，你会发现触发该API操作的时候磁盘不但没有被释放，反而磁盘使用率上升了。
     * 注意：
     * 在删除过程中要确定集群磁盘有一定的余量，因为标记删除需要占用磁盘空间。如果磁盘空间不够，这个操作的失败率还是很大的。
     */
    public void deleteByQueryDocument() {
        DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest("hotel");
        QueryBuilder queryBuilder = new TermQueryBuilder("business","四川北路商业区");
        deleteByQueryRequest.setQuery(queryBuilder);
        try {
            client.deleteByQuery(deleteByQueryRequest,RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

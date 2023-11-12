package com.taoz.boost.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author taozheng
 * @create 2023-11-12 12:50 下午
 * @introduce:
 */
@Slf4j
@Data
@Configuration
public class EsConfig {

    @Value("$(spring.elasticsearch.rest.uris)")
    private String host;


    @Bean
    public RestHighLevelClient client(){
        return new RestHighLevelClient(RestClient.builder(
                 HttpHost.create("http://1.94.62.124:9200")
        ));
    }
}

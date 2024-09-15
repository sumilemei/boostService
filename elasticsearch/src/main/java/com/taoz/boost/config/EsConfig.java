package com.taoz.boost.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.Resource;

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

    @Resource
    private ConfigUtils configUtils;


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    @Bean
    public RestHighLevelClient client(){
        return new RestHighLevelClient(RestClient.builder(
                 HttpHost.create(configUtils.getConfig("spring.elasticsearch.rest.uris"))
        ));
    }
}

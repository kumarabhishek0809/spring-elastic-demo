package com.spring.elasticsearch.application.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories(basePackages = {"com.spring.elasticsearch.application.repository"})
public class ElasticSearchConfig {

    private static final String elasticSearchHost = "127.0.0.1";
    private static final int elasticSearchPort = 9300;

    @Bean
    public TransportClient client() throws UnknownHostException {
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY);
        transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName(elasticSearchHost), elasticSearchPort));
        return transportClient;
    }

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(elasticSearchHost, elasticSearchPort, "http")
                ));
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchRestOperations() throws UnknownHostException {
        return new ElasticsearchRestTemplate(restHighLevelClient());
    }


    @Bean
    public ElasticsearchOperations elasticsearchOperations() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }

}


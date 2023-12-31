/*package com.trainee.core.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author Phillip Verheyden (phillipuniverse)
 */
/*@Component
public class ApplicationSolrConfiguration {

    @Value("${solr.url.primary}")
    protected String primaryCatalogSolrUrl;
    
    @Value("${solr.url.reindex}")
    protected String reindexCatalogSolrUrl;
    
    @Value("${solr.url.admin}")
    protected String adminCatalogSolrUrl;

    @Bean
    public SolrClient primaryCatalogSolrClient() {
        return new HttpSolrClient.Builder(primaryCatalogSolrUrl).build();
    }
    
    @Bean
    public SolrClient reindexCatalogSolrClient() {
        return new HttpSolrClient.Builder(reindexCatalogSolrUrl).build();
    }
    
    @Bean
    public SolrClient adminCatalogSolrClient() {
        return new HttpSolrClient.Builder(adminCatalogSolrUrl).build();
    }

    @Bean
    public SolrConfiguration blCatalogSolrConfiguration() throws IllegalStateException {
        return new SolrConfiguration(primaryCatalogSolrClient(), reindexCatalogSolrClient(), adminCatalogSolrClient());
    }

    @Bean
    protected SearchService blSearchService() {
        return new SolrSearchServiceImpl();
    }
    
}*/

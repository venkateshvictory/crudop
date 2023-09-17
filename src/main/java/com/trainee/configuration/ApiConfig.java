/*package com.trainee.configuration;

import org.apache.catalina.connector.Connector;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;



import java.util.Collections;
import java.util.List;

/**
 * @author Elbert Bautista (elbertbautista)
 */
/*@Configuration
@Import({CoreConfig.class, SecurityConfig.class})
public class ApiConfig {

    @Bean
    @ConditionalOnProperty("jmx.app.name")
    public StringFactoryBean blJmxNamingBean() {
        return new StringFactoryBean();
    }

    /**
     * Spring Boot does not support the configuration of both an HTTP connector and an HTTPS connector via properties.
     * In order to have both, we’ll need to configure one of them programmatically (HTTP).
     * Below is the recommended approach according to the Spring docs:
     * {@link https://github.com/spring-projects/spring-boot/blob/1.5.x/spring-boot-docs/src/main/asciidoc/howto.adoc#configure-ssl}
     * @param httpServerPort
     * @return EmbeddedServletContainerFactory
     */
   /* @Bean
    public TomcatServletWebServerFactory tomcatEmbeddedServletContainerFactory(@Value("${http.server.port:8082}") int httpServerPort) {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector(httpServerPort));
        return tomcat;
    }
    
    @Merge("blMergedCacheConfigLocations")
    public List<String> adminOverrideCache() {
        return Collections.singletonList("classpath:bl-override-ehcache.xml");
    }

    private Connector createStandardConnector(int port) {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(port);
        return connector;
    }

    
    @Primary
    @Bean
    public FreeMarkerConfigurationFactoryBean factoryBean() {
    	FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
    	bean.setTemplateLoaderPath("classpath:/templates");
    	return bean;
    }
    
    
}*/

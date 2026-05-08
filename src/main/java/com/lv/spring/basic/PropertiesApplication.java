package com.lv.spring.basic;

import com.lv.spring.basic.props.SomeExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class PropertiesApplication {

    private static final Logger log = LoggerFactory.getLogger(PropertiesApplication.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext =
                     new AnnotationConfigApplicationContext(PropertiesApplication.class)) {

            SomeExternalService someExternalService = applicationContext.getBean(SomeExternalService.class);
            log.info("someExternalService: {}", someExternalService);
            log.info("someExternalService.returnServiceUrl(): {}", someExternalService.returnServiceUrl());
        }
    }
}

package com.lv.spring.basic;

import com.lv.spring.componentscan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.lv.spring.componentscan")
public class ComponentScanApplication {

    private static final Logger log = LoggerFactory.getLogger(ComponentScanApplication.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext =
                     new AnnotationConfigApplicationContext(ComponentScanApplication.class)) {
            //Bean scope: by default it's a singleton bean
            ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);
            log.info("componentDAO: {}", componentDAO);
        }
    }
}

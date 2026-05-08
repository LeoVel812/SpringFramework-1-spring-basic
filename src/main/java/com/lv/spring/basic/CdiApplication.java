package com.lv.spring.basic;

import com.lv.spring.basic.cdi.SomeCdiBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CdiApplication {

    private static final Logger log = LoggerFactory.getLogger(CdiApplication.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext =
                     new AnnotationConfigApplicationContext(CdiApplication.class)) {

            SomeCdiBusiness someCdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);
            log.info("someCdiBusiness: {}", someCdiBusiness);
            log.info("someCdiBusiness.getSomeCdiDao(): {}", someCdiBusiness.getSomeCdiDao());
        }
    }
}

package com.lv.spring.basic;

import com.lv.spring.basic.cdi.SomeCdiBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CdiApplication {

    private static final Logger log = LoggerFactory.getLogger(CdiApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CdiApplication.class, args);
        SomeCdiBusiness someCdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);
        log.info("someCdiBusiness: {}", someCdiBusiness);
        log.info("someCdiBusiness.getSomeCdiDao(): {}", someCdiBusiness.getSomeCdiDao());
    }
}

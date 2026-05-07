package com.lv.spring.basic;

import com.lv.spring.componentscan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// By default it only scans components on this package and its subpackages
@ComponentScan("com.lv.spring.componentscan")
public class ComponentScanApplication {

    private static final Logger log = LoggerFactory.getLogger(ComponentScanApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ComponentScanApplication.class, args);
        //Bean scope: by default it's a singleton bean
        ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);
        log.info("componentDAO: {}", componentDAO);
    }
}

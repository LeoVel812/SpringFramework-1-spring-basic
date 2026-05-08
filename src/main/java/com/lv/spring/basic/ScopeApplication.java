package com.lv.spring.basic;

import com.lv.spring.basic.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ScopeApplication {

    private static final Logger log = LoggerFactory.getLogger(ScopeApplication.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext =
                     new AnnotationConfigApplicationContext(ScopeApplication.class);) {
            //Bean scope: by default it's a singleton bean
            PersonDAO personDAOBean1 = applicationContext.getBean(PersonDAO.class);
            PersonDAO personDAOBean2 = applicationContext.getBean(PersonDAO.class);
            log.info("personDAOBean1: {}", personDAOBean1);
            log.info("personDAOBean1.getJdbcConnection(): {}", personDAOBean1.getJdbcConnection());
            log.info("personDAOBean2: {}", personDAOBean2);
            log.info("personDAOBean2.getJdbcConnection(): {}", personDAOBean2.getJdbcConnection());
        }
    }
}

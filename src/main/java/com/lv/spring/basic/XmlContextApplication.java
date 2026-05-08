package com.lv.spring.basic;

import com.lv.spring.basic.xml.XmlPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XmlContextApplication {

    private static final Logger log = LoggerFactory.getLogger(XmlContextApplication.class);

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext applicationContext =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {

            XmlPersonDAO xmlPersonDAO = applicationContext.getBean(XmlPersonDAO.class);
            log.info("Setting Autowiring with XML");
            log.info("Beans loaded: {}", Arrays.toString(applicationContext.getBeanDefinitionNames()));
            log.info("xmlPersonDAO: {}", xmlPersonDAO);
            log.info("someCdiBusiness.getXmlJdbcConnection(): {}", xmlPersonDAO.getXmlJdbcConnection());
        }
    }
}

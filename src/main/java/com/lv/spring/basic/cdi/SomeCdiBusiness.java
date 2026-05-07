package com.lv.spring.basic.cdi;

import com.lv.spring.basic.CdiApplication;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;

//@Named
@Component
public class SomeCdiBusiness {
    private static final Logger log = LoggerFactory.getLogger(SomeCdiBusiness.class);
//    @Inject
    private SomeCdiDao someCdiDao;


    public SomeCdiBusiness(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
    }

    public SomeCdiDao getSomeCdiDao() {
        return someCdiDao;
    }

    public void setSomeCdiDao(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
    }

    // As soon as this currently bean is created its dependencies are initialized,
    // this method will be called
    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct of: {}", this.getClass().getSimpleName());
    }

    // Just before this bean is removed from the Container
    // this method will be called
    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy of: {}", this.getClass().getSimpleName());
    }
}

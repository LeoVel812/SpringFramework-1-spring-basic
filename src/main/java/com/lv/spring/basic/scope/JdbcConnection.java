package com.lv.spring.basic.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JdbcConnection {
    private static final Logger log = LoggerFactory.getLogger(JdbcConnection.class);

    public JdbcConnection() {
        log.info("JDBC Connection");
    }

}

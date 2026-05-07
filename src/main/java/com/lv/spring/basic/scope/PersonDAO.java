package com.lv.spring.basic.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PersonDAO {
    JdbcConnection jdbcConnection;

    public PersonDAO(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    public JdbcConnection getJdbcConnection() {
        return jdbcConnection;
    }

    public void setJdbcConnection(JdbcConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

}

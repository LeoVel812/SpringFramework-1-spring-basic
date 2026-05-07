package com.lv.spring.componentscan;

import org.springframework.stereotype.Component;

@Component
public class ComponentDAO {
    ComponentJdbcConnection componentJdbcConnection;

    public ComponentDAO(ComponentJdbcConnection componentJdbcConnection) {
        this.componentJdbcConnection = componentJdbcConnection;
    }

    public ComponentJdbcConnection getComponentJdbcConnection() {
        return componentJdbcConnection;
    }

    public void setComponentJdbcConnection(ComponentJdbcConnection componentJdbcConnection) {
        this.componentJdbcConnection = componentJdbcConnection;
    }

}

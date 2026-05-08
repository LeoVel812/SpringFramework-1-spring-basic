package com.lv.spring.basic.xml;

public class XmlPersonDAO {
    XmlJdbcConnection xmlJdbcConnection;

    public XmlPersonDAO() {
    }

    public XmlPersonDAO(XmlJdbcConnection xmlJdbcConnection) {
        this.xmlJdbcConnection = xmlJdbcConnection;
    }

    public XmlJdbcConnection getXmlJdbcConnection() {
        return xmlJdbcConnection;
    }

    public void setXmlJdbcConnection(XmlJdbcConnection xmlJdbcConnection) {
        this.xmlJdbcConnection = xmlJdbcConnection;
    }

}

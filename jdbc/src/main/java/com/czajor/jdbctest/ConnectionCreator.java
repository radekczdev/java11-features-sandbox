package com.czajor.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionCreator {

  public static final String DB_USER = "DB_USER";
  public static final String DB_PASS = "DB_PASS";
  public static final String DB_ADDRESS = "DB_ADDRESS";

  static Connection getConnection() throws SQLException, ClassNotFoundException {
    Properties connectionProps = new Properties();
    connectionProps.put("user", System.getenv(DB_USER));
    connectionProps.put("password", System.getenv(DB_PASS));
    connectionProps.put(DB_ADDRESS, System.getenv(DB_ADDRESS));
//    Class.forName("oracle.jdbc.driver.OracleDriver");

    Connection connection = DriverManager.getConnection((String) connectionProps.get(DB_ADDRESS), connectionProps);
    log.info("Connected to DB");
    return connection;
  }
}

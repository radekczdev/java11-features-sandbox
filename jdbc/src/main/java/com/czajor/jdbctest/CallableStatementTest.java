package com.czajor.jdbctest;

import java.sql.Connection;
import java.sql.SQLException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CallableStatementTest {

  public static void main(String[] args) throws ClassNotFoundException {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    try (Connection connection = ConnectionCreator.getConnection()) {

    } catch (SQLException exception) {
      log.error("Problem with connection: ", exception);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}

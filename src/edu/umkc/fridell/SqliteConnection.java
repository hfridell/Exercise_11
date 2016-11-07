package edu.umkc.fridell;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class SqliteConnection {
  private static Connection conn = null;

  public static Connection connect() {
    try {
      Class.forName("org.sqlite.JDBC");
      // db parameters
      String url = "jdbc:sqlite:questionDB.sqlite";
      conn = DriverManager.getConnection(url);
      return conn;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Statement createStatement() throws SQLException {
    if (conn == null){
      connect();
    }
    return conn.createStatement();
  }
}
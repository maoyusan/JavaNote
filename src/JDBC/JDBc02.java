package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBc02 {
  public static void main(String[] args) {
    ResourceBundle r = ResourceBundle.getBundle("JDBC/Info");
    String driver = r.getString("driver");
    String url = r.getString("url");
    String user = r.getString("user");
    String password = r.getString("password");
    Connection connection = null;
    try {
      Class.forName(driver);
      connection = DriverManager.getConnection(url, user, password);
      System.out.println(connection);

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    } finally {
      assert connection != null;
      try {
        connection.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }
}

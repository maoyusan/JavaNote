package JDBC;

import java.sql.*;
import java.util.ResourceBundle;

public class Jdbc02 {
  public static void main(String[] args) {
    ResourceBundle r = ResourceBundle.getBundle("JDBC/Info");
    String driver = r.getString("driver");
    String url = r.getString("url");
    String user = r.getString("user");
    String password = r.getString("password");
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, user, password);
      System.out.println(conn != null ? "连接成功" : "连接失败");
      stmt = conn.createStatement();
      rs = stmt.executeQuery("select * from cj");
      System.out.println("学号 " + "课程号 " + "成绩 ");
      while (rs.next()) {
        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
      }

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      try {
        if (stmt != null) {
          stmt.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }
}

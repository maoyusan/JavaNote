package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TransactionRollback {
  public static void main(String[] args) {
    ResourceBundle r = ResourceBundle.getBundle("JDBC/Info");
    String driver = r.getString("driver");
    String url = r.getString("url");
    String user = r.getString("user");
    String password = r.getString("password");
    Connection conn = null;
    PreparedStatement ps = null;

    try {

      Class.forName(driver);
      conn = DriverManager.getConnection(url, user, password);
      ps = conn.prepareStatement("update test.money set money.money=? where money.id=?");
      conn.setAutoCommit(false);
      ps.setInt(2, 1);
      ps.setDouble(1, 23232);
      int count = ps.executeUpdate();

      ps.setInt(2, 2);
      ps.setDouble(1, 11111);
      count += ps.executeUpdate();
      conn.commit();
      System.out.println(count == 2 ? "执行成功" : "执行失败");

    } catch (SQLException | ClassNotFoundException throwables) {
      if (conn != null) {
        try {
          conn.rollback();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      throwables.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
      if (ps != null) {
        try {
          ps.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
    }
  }
}

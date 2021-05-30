package JDBC;

import java.sql.*;

public class JdbcUtil {
  private JdbcUtil() {}

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection conn() throws SQLException {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "123456");
    if (conn != null) {
      System.out.println("登录成功！");
      return conn;
    }
    System.out.println("登录失败！");
    return null;
  }

  public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
    if (con != null) {
      try {
        con.close();
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
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }
}

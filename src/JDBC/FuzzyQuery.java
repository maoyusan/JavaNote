package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuzzyQuery {
  public static void main(String[] args) {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conn = JdbcUtil.conn();
      assert conn != null;
      ps = conn.prepareStatement("select *from test.xs where 姓名 like ?");
      ps.setString(1, "_林%");
      rs = ps.executeQuery();
      System.out.println("姓名");
      while (rs.next()) {
        System.out.println(rs.getString("姓名"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      JdbcUtil.close(conn, ps, rs);
    }
  }
}

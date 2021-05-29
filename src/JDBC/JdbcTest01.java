package JDBC;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest01 {
  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    try {
      /*注册驱动程序*/
      Driver driver = new Driver();
      DriverManager.registerDriver(driver);
      /*获取连接*/
      con =
          DriverManager.getConnection(
              "jdbc:mysql://42.192.37.101:3306/mysql0991851_db", "mysql0991851", "Huajian1314");
      System.out.println(con);
      String msql = "insert into xs\n" + "values ('张三');\n";
      /*创建一个操作mysql对象*/
      stmt = con.createStatement();
      /*执行MySQL inset into delete select语句*/
      int count = stmt.executeUpdate(msql);
      /*输出返回结果*/
      System.out.println(count == 1 ? "成功" : "失败");
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        /*分开try 关闭通道*/
        stmt.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      try {
        con.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }
}

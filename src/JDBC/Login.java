package JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Login {
  public static void main(String[] args) {

    Map<String, String> map = initUi();
    Boolean success = login(map);
    System.out.println(success ? "成功成功" : "登录失败");
  }

  private static Boolean login(Map<String, String> userinfo) {
    String ur = userinfo.get("loginName");
    String psw = userinfo.get("passWord");
    ResourceBundle r = ResourceBundle.getBundle("JDBC/Info");
    String driver = r.getString("driver");
    String url = r.getString("url");
    String user = r.getString("user");
    String password = r.getString("password");
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Boolean result = false;

    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, user, password);
      ps = conn.prepareStatement("select *from test.t_user where username =?  and password =?");
      ps.setString(1, ur);
      ps.setString(2, psw);
      rs = ps.executeQuery();
      if (rs.next()) {
        result = true;
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
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
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
    }
    return result;
  }

  private static Map<String, String> initUi() {
    Map<String, String> values = new HashMap<>(10);
    Scanner in = new Scanner(System.in);
    System.out.println("请输入用户名");
    String user = in.nextLine();
    System.out.println("请输入密码");
    String password = in.nextLine();
    values.put("loginName", user);
    values.put("passWord", password);
    return values;
  }
}

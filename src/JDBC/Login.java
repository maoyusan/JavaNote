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
    String un = userinfo.get("loginName");
    String ps = userinfo.get("passWord");
    ResourceBundle r = ResourceBundle.getBundle("JDBC/Info");
    String driver = r.getString("driver");
    String url = r.getString("url");
    String user = r.getString("user");
    String password = r.getString("password");
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;
    Boolean result = false;

    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, user, password);
      stat = conn.createStatement();
      rs =
          stat.executeQuery(
              "select *from t_user where username = '" + un + "' and password ='" + ps + "'");
      if (rs.next()) {

        result = true;
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
    }
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    if (stat != null) {
      try {
        stat.close();
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

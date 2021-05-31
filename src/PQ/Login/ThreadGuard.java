package PQ.Login;

import JDBC.JdbcUtil;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThreadGuard implements Runnable {
  Connection conn = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  Boolean result = false;
  Socket accept;

  ThreadGuard(Socket a) {

    this.accept = a;
  }

  @Override
  public void run() {
    ObjectInputStream ois = null;
    OutputStream os = null;
    DataOutputStream dos = null;
    try {
      InputStream is = accept.getInputStream();
      ois = new ObjectInputStream(is);
      User user = (User) ois.readObject();
      conn = JdbcUtil.conn();
      assert conn != null;
      ps = conn.prepareStatement("select *from test.t_user where username=? and password =?");

      ps.setString(1, user.data.get("name"));
      ps.setString(2, user.data.get("psw"));

      rs = ps.executeQuery();
      while (rs.next()) {
        result = true;
      }
      os = accept.getOutputStream();
      dos = new DataOutputStream(os);
      dos.writeBoolean(result);
    } catch (IOException | ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    } finally {
      JdbcUtil.close(conn, ps, rs);
      try {
        assert dos != null;
        dos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        os.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        ois.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        accept.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}

package PQ.Login;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws IOException {
    User user = new User();
    InetAddress ip = InetAddress.getLocalHost();
    Socket s = new Socket(ip.getHostAddress(), 8888);

    OutputStream os = s.getOutputStream();
    ObjectOutputStream obj = new ObjectOutputStream(os);
    obj.writeObject(user);

    InputStream is = s.getInputStream();
    DataInputStream dis = new DataInputStream(is);
    System.out.println(dis.readBoolean() ? "登录成功！" : "登录失败！");
    dis.close();
    obj.close();
    s.close();
  }
}

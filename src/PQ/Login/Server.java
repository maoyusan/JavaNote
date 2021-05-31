package PQ.Login;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {
    System.out.println("服务端已启动");
    ServerSocket ss = null;
    Socket accept = null;
    int count = 0;
    try {
      ss = new ServerSocket(8888);
      while (true) {
        accept = ss.accept();
        new Thread(new ThreadGuard(accept)).start();
        count++;
        System.out.println("已接受客服请求的次数:" + count + "客服的ip地址为" + accept.getInetAddress());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (ss != null) {

        try {
          ss.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (accept != null) {

        try {
          accept.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

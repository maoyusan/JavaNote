package NetWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class TestUdp {
  public static void main(String[] args) throws IOException {
    System.out.println("学生上线了");
    DatagramSocket ds;
    ds = new DatagramSocket(8888);
    while (true) {
      Scanner in = new Scanner(System.in);
      String str = in.nextLine();
      byte[] b = str.getBytes();
      DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 9999);
      ds.send(dp);
      if ("bye".equals(str)) {
        System.out.println("您下线了");
        break;
      }
      DatagramPacket dp2 = new DatagramPacket(b, b.length);
      ds.receive(dp);
      String str2 = new String(dp2.getData(), 0, dp.getLength());
      System.out.println("老师:" + str2);
    }
    ds.close();
  }
}

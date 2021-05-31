package NetWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class TestUdp2 {
  public static void main(String[] args) throws IOException {
    System.out.println("老师上线了！");
    DatagramSocket ds = new DatagramSocket(9999);
    DatagramPacket dp2;
    while (true) {
      byte[] b = new byte[1024];
      DatagramPacket dp = new DatagramPacket(b, b.length);
      ds.receive(dp);
      String str = new String(dp.getData(), 0, dp.getLength());
      System.out.println("学生: " + str);
      if ("bye".equals(str)) {
        System.out.println("学生下线了");
        break;
      }
      Scanner in = new Scanner(System.in);
      String str2 = in.nextLine();
      byte[] b2 = str2.getBytes();
      dp2 = new DatagramPacket(b2, b2.length, InetAddress.getLocalHost(), 8888);
      ds.send(dp2);
    }
  }
}

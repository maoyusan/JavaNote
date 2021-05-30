package NetworkProgramming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Is {
  public static void main(String[] args) throws UnknownHostException {
    InetAddress ia = InetAddress.getByName("WIN-20200101YNY");
    InetAddress ia2 = InetAddress.getByName("www.baidu.com");
    InetAddress ia3 = InetAddress.getByName("localhost");
    System.out.println(ia);
    System.out.println(ia2);
    System.out.println(ia3);
    System.out.println(ia3.getHostAddress());
    System.out.println(ia3.getHostName());
  }
}

package NetWork;

import java.net.InetSocketAddress;

public class Isa {
  public static void main(String[] args) {
    InetSocketAddress isa = new InetSocketAddress("192.168.195.177", 24);
    System.out.println(isa.getHostString());
    System.out.println(isa.getAddress());
    System.out.println(isa.getHostName());
    System.out.println(isa.getPort());
  }
}

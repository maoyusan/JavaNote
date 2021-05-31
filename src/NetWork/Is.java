package NetWork;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class Is {
  public static void main(String[] args) throws UnknownHostException {
    InetAddress ia = InetAddress.getByName("WIN-20200101YNY");
    InetAddress ia2 = InetAddress.getByName("www.baidu.com");
    InetAddress ia3 = InetAddress.getByName("localhost");
    InetAddress ia4 = InetAddress.getLocalHost();
    System.out.println(ia);
    System.out.println(ia2);
    System.out.println(ia3);
    System.out.println(ia3.getHostAddress());
    System.out.println(ia3.getHostName());
    System.out.println(ia4.getHostAddress());
    System.out.println("-----------------");
    try {
      InetAddress addr = InetAddress.getLocalHost();
      // 获取本机ip
      String ip = addr.getHostAddress().toString();

      // 获取本机计算机名称
      String hostName = addr.getHostName().toString();

      System.out.println("本机IP：" + ip + "\n本机名称:" + hostName);
      Properties props = System.getProperties();
      System.out.println("操作系统的名称：" + props.getProperty("os.name"));
      System.out.println("操作系统的版本：" + props.getProperty("os.version"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

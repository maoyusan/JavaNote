package practiceQuestions.Login;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Test {
  public static void main(String[] args) throws IOException {
    InetAddress ip = InetAddress.getLocalHost();
    System.out.println(ip.getHostAddress());
    Socket socket = new Socket(ip.getHostAddress().substring(1), 8888);
  }
}

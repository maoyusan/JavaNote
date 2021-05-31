package NetWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
  public static void main(String[] args) throws IOException {
    /*创建一个套接字*/
    ServerSocket ss = new ServerSocket(8888);
    /*等待客服端发送套接字，进入堵塞状态*/
    Socket s = ss.accept();
    /*创建一个输入流，用数据流包装该输入流，并读取*/
    InputStream is = s.getInputStream();
    DataInputStream dis = new DataInputStream(is);
    System.out.println(dis.readFloat());
    System.out.println(dis.readUTF());
    /*向客服端发送信息，创建一个输出流*/
    OutputStream ops = s.getOutputStream();
    DataOutputStream ds = new DataOutputStream(ops);
    ds.writeUTF("我已接受到请求");

    dis.close();
    is.close();
    s.close();
  }
}

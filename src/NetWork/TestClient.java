package NetWork;

import java.io.*;
import java.net.Socket;

public class TestClient {
  public static void main(String[] args) throws IOException {
    /*创造套接字*/
    Socket s = new Socket("WIN-20200101YNY", 8888);
    /*利用流对外输入*/
    OutputStream os = s.getOutputStream();
    DataOutputStream dos = new DataOutputStream(os);
    /*调用UTF字符编码输出字符串的方法*/
    dos.writeFloat(23333);
    dos.writeUTF("hello word");

    /*再创建一个输入流，接受服务端发送的流*/
    InputStream i = s.getInputStream();
    DataInputStream dis = new DataInputStream(i);
    System.out.println(dis.readUTF());

    /*关闭流*/
    dos.close();
    os.close();
    s.close();
  }
}

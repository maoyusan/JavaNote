package Iotest;

import java.io.*;

public class BufferedIoStream {
  public BufferedIoStream() throws FileNotFoundException {}

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(new FileInputStream("D:\\测试文本2.txt")));

    BufferedWriter bufferedWriter =
        new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\测试文本2.txt")));

    bufferedWriter.write("你妈的，为什么");

    bufferedWriter.flush();
    bufferedWriter.close();
    System.out.println(reader.readLine());
    reader.close();
  }
}

package Iotest;

import java.io.FileReader;
import java.io.IOException;

public class CharacterStream {
  public static void main(String[] args) {
    FileReader reader = null;
    try {

      reader = new FileReader("D:\\测试文本2.txt");
      char[] chars = new char[4];
      int count;
      while ((count = reader.read(chars)) != -1) {
        System.out.print(new String((chars), 0, count));
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

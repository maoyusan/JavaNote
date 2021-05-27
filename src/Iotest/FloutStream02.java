package Iotest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FloutStream02 {
  public static void main(String[] args) {
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream("D://测试文本", true);
      byte[] bytes = {97, 98, 99, 100};
      try {
        fos.write(bytes, 2, 2);

        fos.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

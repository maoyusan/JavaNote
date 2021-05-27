package Iotest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class File01 {

  public static void main(String[] args) {

    File file = new File("D:\\测试文本2.txt");

    try {
      if (!file.exists()) {
        file.createNewFile();
      }

      System.out.println(file.getName());
      System.out.println(file.isDirectory());
      System.out.println(file.isFile());

      Date date = new Date(file.lastModified());
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      System.out.println(sdf.format(date));

      System.out.println(Arrays.toString(file.listFiles()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

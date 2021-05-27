package Iotest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Pro {
  public static void main(String[] args) {
    try {
      FileReader reader = new FileReader("D:\\ja\\src\\信息.Properties");
      Properties pro = new Properties();
      pro.load(reader);
      String username = pro.getProperty("username");
      System.out.println(username);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

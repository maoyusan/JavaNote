package reflex;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbsolutePath02 {
  public static void main(String[] args) throws IOException {

    InputStream in =
        Thread.currentThread().getContextClassLoader().getResourceAsStream("信息.Properties");
    Properties pro = new Properties();
    pro.load(in);
    System.out.println(pro.getProperty("classname"));
    Thread.currentThread().getContextClassLoader().getResourceAsStream("");
  }
}

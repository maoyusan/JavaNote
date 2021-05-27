package reflex;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Reflex02 {
  public static void main(String[] args)
      throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    InputStream fr =
        Thread.currentThread().getContextClassLoader().getResourceAsStream("信息.Properties");
    /*创建一个字符流*/
    Properties properties = new Properties();
    /*继承一个hashtable，表示一个属性集*/

    properties.load(fr);
    /*读取属性集*/

    fr.close();
    String obj = properties.getProperty("classname");
    /*获取classname的key 的值*/

    Class c = Class.forName(obj);
    /*创建一个class*/

    c.newInstance();
    /*创建一个class的实例对象*/
    Object obj1 = c.newInstance();

    System.out.println(obj1);
  }
}

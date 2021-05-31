package PQ.Login;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User implements Serializable {
  private static final long serialVersionUID = 6811444387101577751L;
  Map<String, String> data = init();

  private static Map<String, String> init() {
    Map<String, String> map = new HashMap<>(2);
    Scanner in = new Scanner(System.in);
    System.out.println("请输入您的账号");
    String name = in.nextLine();
    System.out.println("请输入您的密码");
    String password = in.nextLine();
    map.put("name", name);
    map.put("psw", password);
    return map;
  }
}

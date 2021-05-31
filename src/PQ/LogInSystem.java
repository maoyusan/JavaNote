package PQ;

import java.util.Scanner;

public class LogInSystem {
  String user;
  String password;
  String[] userNames = new String[10];
  String[] passWords = new String[10];

  public static void main(String[] args) {
    LogInSystem logInSystem = new LogInSystem();
    for (; ; ) {
      System.out.println("欢迎使用本系统！");
      System.out.println("登录功能 请按1");
      System.out.println("注册功能 请按2");
      System.out.println("查看功能 请按3");
      System.out.println("退出功能 请按4");

      int a;
      Scanner s = new Scanner(System.in);
      a = s.nextInt();

      switch (a) {
        case 1:
          logInSystem.logIn();
          break;
        case 2:
          logInSystem.zhuCe();
          break;
        case 3:
          logInSystem.look();
          break;
        case 4:
          System.out.println("感谢您的使用");
          System.exit(0);
        default:
          System.out.println("无效操作！");
          break;
      }
    }
  }

  public void logIn() {
    Scanner s = new Scanner(System.in);
    int num = 3;

    for (int i = 0; i < userNames.length; i++) {
      System.out.println("请输入您的账号：");
      user = s.nextLine();
      System.out.println("请输入您的密码：");
      password = s.nextLine();
      for (int j = 0; j < userNames.length; j++) {
        if (user.equals(userNames[j]) && password.equals(passWords[j])) {
          System.out.println("登录成功！");
          System.out.println();
          return;
        }
      }
      num--;
      System.out.println("密码错误，您还有" + num + "次机会");
      if (num == 0) {
        System.out.println("已超过三次，返回主页面");
        return;
      }
    }
  }

  public void zhuCe() {
    Scanner s = new Scanner(System.in);
    for (int i = 0; i < userNames.length; i++) {
      if (userNames[i] == null) {
        System.out.println("请输入您要注册的账号");
        userNames[i] = s.nextLine();
        System.out.println("请输入您要注册的密码");
        passWords[i] = s.nextLine();
        System.out.println("注册成功！");
        System.out.println();
        return;
      }
    }
  }

  public void look() {
    System.out.println("已输出所有用户信息");
    for (int i = 0; i < userNames.length; i++) {
      if (userNames[i] != null) {
        System.out.println("账号：" + userNames[i]);
        System.out.println("密码：" + passWords[i]);
      }
    }
  }
}

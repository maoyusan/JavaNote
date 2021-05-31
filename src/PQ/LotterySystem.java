package PQ;

import java.util.Random;
import java.util.Scanner;

public class LotterySystem {

  String[] audience = new String[4];

  public static void main(String[] args) {
    LotterySystem lotterySystem = new LotterySystem();
    System.out.println("欢迎使用随机抽观众系统！");
    for (; ; ) {
      System.out.println("存储观众 请按1");
      System.out.println("查看观众 请按2");
      System.out.println("抽取观众 请按3");
      System.out.println("关闭系统 请按4");
      Scanner scanner = new Scanner(System.in);
      int a = 0;
      a = scanner.nextInt();
      switch (a) {
        case 1:
          lotterySystem.cunChu();
          break;
        case 2:
          lotterySystem.reveal();
          break;
        case 3:
          lotterySystem.siphon();
          break;
        default:
          System.exit(0);
      }
    }
  }

  public void cunChu() {
    Scanner scanner = new Scanner(System.in);
    for (int i = 1; i < audience.length; i++) {
      if (audience[i] == null) {
        System.out.println("请输入观众" + i + "名字：");
        audience[i] = scanner.next();
        System.out.println("存储成功！");
        System.out.println();
      }
    }
  }

  public void reveal() {
    System.out.println("已输出所有观众");
    for (int i = 1; i < audience.length; i++) {
      if (audience[i] != null) {
        System.out.println(audience[i]);
      }
    }
  }

  public void siphon() {
    Random r = new Random();
    int suiJi = (r.nextInt(3) + 1);
    System.out.println("已随机抽取观众" + audience[suiJi]);
    System.out.println();
  }
}

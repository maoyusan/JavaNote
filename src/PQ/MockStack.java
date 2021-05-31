package PQ;

import java.util.Scanner;

public class MockStack {

  Object[] zan = new Object[10];
  int i = -1;

  public static void main(String[] args) {
    MockStack mockStack = new MockStack();
    for (; ; ) {
      System.out.println("查看指针 请按1");
      System.out.println("压栈 请按2");
      System.out.println("弹栈 请按3");
      System.out.println("退出 请按4");
      int a;
      Scanner scanner = new Scanner(System.in);
      a = scanner.nextInt();
      switch (a) {
        case 1:
          mockStack.zhiZhen();
          break;
        case 2:
          mockStack.push();
          break;
        case 3:
          mockStack.pop();
          break;
        default:
          System.exit(0);
      }
    }
  }

  public void zhiZhen() {
    System.out.println("当前指针的为" + i);
  }

  public void push() {
    i++;
    System.out.println("压栈成功！");
    zan[i] = i;
    if (i == zan.length - 1) {
      System.out.println("栈已满！");
    }
  }

  public void pop() {
    if (i >= 0) {
      System.out.println("弹栈成功！");
    }
    if (i == -1) {
      System.out.println("栈已空！");
      zan[0] = null;
    }
    if (i >= 0) {
      i--;
    }
  }
}

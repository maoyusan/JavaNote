package Thread;

public class ThreadTest {
  public static void main(String[] args) {
    Mothered a = new Mothered();
    a.start();
    int b = 1000;
    for (int i = 0; i < b; i++) {
      System.out.println("主线程:" + i);
    }
  }
}

class Mothered extends Thread {

  @Override
  public void run() {
    int a = 1000;
    for (int i = 0; i < a; i++) {
      System.out.println("次线程:" + i);
    }
  }
}

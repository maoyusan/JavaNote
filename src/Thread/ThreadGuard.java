package Thread;

public class ThreadGuard {
  public static void main(String[] args) {
    Thread t1 = new Thread(new Threaded());
    t1.setName("t1");
    t1.setDaemon(true);
    t1.start();
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + "----->" + i);
    }
  }
}

class Threaded implements Runnable {
  int i = 0;

  @Override
  public void run() {
    while (true) {
      i++;
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + "--->" + (i));
    }
  }
}

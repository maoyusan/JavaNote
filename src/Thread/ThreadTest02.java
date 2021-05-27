package Thread;

public class ThreadTest02 {
  public static void main(String[] args) {

    try {
      /*让当前线程进入休眠状态*/
      Thread.sleep(1000 * 3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Mythread b = new Mythread();
    b.runa = false;
    Thread a = new Thread(new Mythread());

    new Mythread().runa = false;
    a.start();
    try {
      a.join();
      /*合并到主线程，主线程堵塞，让a执行完*/
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(a.getName());
    /*获取线程名字*/
    System.out.println(Thread.currentThread().getName());
    /*获取当前线程名字*/

    /*如何终止睡眠*/
    Thread.currentThread().setPriority(10);
    /*设置当前线程的优先度为10 main*/
    new Mythread().runa = true;
  }
}

class Mythread extends Thread implements Runnable {
  boolean runa = true;

  @Override
  public void run() {
    if (runa) {
      Thread.yield();
      /*线程暂停一下，让位给主线程*/
      try {
        Thread.sleep(1000 * 60);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

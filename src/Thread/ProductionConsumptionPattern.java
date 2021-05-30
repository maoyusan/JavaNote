package Thread;

import java.util.ArrayList;
import java.util.List;

public class ProductionConsumptionPattern {
  public static void main(String[] args) {
    List<Object> list = new ArrayList<>();
    new Thread(new Warehouse(list)).setName("生产线程");
    new Thread(new Consumption(list)).setName("消费线程");
    new Thread(new Warehouse(list)).start();
    new Thread(new Consumption(list)).start();
  }
}

class Warehouse implements Runnable {
  private List<Object> list;

  public Warehouse(List<Object> list) {
    this.list = list;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (list) {
        if (list.size() > 0) {
          try {
            list.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        Object obj = new Object();
        for (int i = 0; i < 10; i++) {
          list.add(obj);
          System.out.println(Thread.currentThread().getName() + "--->" + obj);
        }
        list.notifyAll();
      }
    }
  }
}

class Consumption implements Runnable {
  private List<Object> list;

  public Consumption(List<Object> list) {
    this.list = list;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (list) {
        if (list.size() == 0) {
          try {
            list.wait();
            /*释放锁，同时让当前线程等待*/
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        for (int i = 0; i < list.size(); i++) {
          System.out.println(Thread.currentThread().getName() + "--->" + list.get(i));
          list.remove(i);
        }
        list.notifyAll();
      }
    }
  }
}

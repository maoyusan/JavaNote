package PQ;

public class BankingSystem {

  public static void main(String[] args) {
    AccountInfo act = new AccountInfo("张三", 10000.0);

    Thread t1 = new Thread(new User(act));
    Thread t2 = new Thread(new User(act));
    Thread t3 = new Thread((new User(new AccountInfo("李四", 10000.0))));
    t1.setName("T1");
    t2.setName("T2");
    t3.setName("T3");
    t1.start();
    t2.start();
    t3.start();
  }

  static class AccountInfo {
    private final String act;
    private Double money;

    public AccountInfo(String act, Double money) {
      this.act = act;
      this.money = money;
    }

    public Double getMoney() {
      return money;
    }

    public void setMoney(Double money) {
      this.money = money;
    }

    public void withdrawal(Double money) {
      synchronized (this) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        setMoney(getMoney() - money);
        System.out.println(act + "取款的余额为" + money);
      }
    }
  }

  static class User implements Runnable {
    private final AccountInfo act;

    public User(AccountInfo act) {
      this.act = act;
    }

    @Override
    public void run() {
      act.withdrawal(2000.0);
      System.out.println(Thread.currentThread().getName() + "剩余余额" + act.getMoney());
    }
  }
}

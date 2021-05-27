package Thread;

public class RUnable {
  public static void main(String[] args) {
    Thread t =
        new Thread(
            new Runnable() {
              @Override
              public void run() {}
            });
    t.start();
  }
}

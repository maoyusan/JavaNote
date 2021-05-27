package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Callable01 {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    FutureTask futureTask =
        new FutureTask(
            new Callable() {
              @Override
              public Object call() throws Exception {
                System.out.println("start");
                Thread.sleep(1000 * 5);
                System.out.println("end");
                int a = 3;
                int b = 4;
                return a + b;
              }
            });

    Thread thread = new Thread(futureTask);

    thread.start();
    System.out.println(futureTask.get());
    System.out.println("hello word");
  }
}

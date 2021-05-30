package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Callable02 {

  public static void main(String[] args) {
    FutureTask futureTask = new FutureTask(new C());
    futureTask.run();
  }
}

class C implements Callable {

  @Override
  public Object call() throws Exception {
    System.out.println("hello");
    return null;
  }
}

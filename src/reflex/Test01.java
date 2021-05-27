package reflex;

public class Test01 {
  public String no;
  private boolean sex;
  protected int id;
  private String name;
  double num;

  static {
    System.out.println("这是一个静态代码块");
  }

  public Test01() {
    System.out.println("这是一个无参构造方法");
  }
}

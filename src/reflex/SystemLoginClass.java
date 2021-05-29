package reflex;

public class SystemLoginClass {

  int no;
  int b;

  public SystemLoginClass(int no, int b) {
    this.no = no;
    this.b = b;
    System.out.println(no + b);
  }

  public SystemLoginClass() {}

  public static boolean longin(String name, String password) {
    return "123".equals(name) && "233".equals(password);
  }

  public static void out() {
    System.out.println("系统已经安全退出！");
  }

  @Override
  public String toString() {
    return "SystemLoginClass{" + "no=" + no + ", b=" + b + '}';
  }
}

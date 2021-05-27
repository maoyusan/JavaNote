package reflex;

public class SystemLoginClass {
  public SystemLoginClass(int no, int b) {
    this.no = no;
    this.b = b;
  }

  int no;
  int b;

  public static boolean longin(String name, String password) {
    return "123".equals(name) && "233".equals(password);
  }

  public static void out() {
    System.out.println("系统已经安全退出！");
  }
}

package reflex;

public class Reflection01 {
  public static void main(String[] args) {
    Class c1 = null;
    try {
      c1 = Class.forName("java.lang.String");
      Class c2 = Class.forName("Java.util.Date");
      Class c3 = Class.forName("java.util.Integer");
      Class c4 = Class.forName("java.lang.system");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    String a = "abc";
    Class s = a.getClass();
    System.out.println(s);
    System.out.println(c1 == s);

    Class x = String.class;
    System.out.println(x);
    System.out.println(s == x);
  }
}

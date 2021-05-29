package reflex;

public class GetParentInterface {
  public static void main(String[] args) throws ClassNotFoundException {
    /*获取父类*/
    Class c = Class.forName("java.lang.String");
    Class s = c.getSuperclass();
    System.out.println(s.getSimpleName());
    /*获取接口*/
    Class[] c1 = c.getInterfaces();
    for (Class Class : c1) {
      System.out.println(Class);
    }

    // 反射机制，获取父类和接口
  }
}

package reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GetAttributes {
  public static void main(String[] args) throws ClassNotFoundException {
    Class c = Class.forName("reflex.Test01");
    String c1 = c.getName();
    System.out.println(c1);
    String c2 = c.getSimpleName();
    System.out.println(c2);
    Field[] f = c.getFields();
    Field[] f2 = c.getDeclaredFields();
    System.out.println("-------------");
    for (Field field : f2) {
      String mod1 = Modifier.toString(field.getModifiers());
      System.out.println(mod1);
      System.out.println(field.getType().getSimpleName());
      System.out.println(field.getName());
    }
  }
}

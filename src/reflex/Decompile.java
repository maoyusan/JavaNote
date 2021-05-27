package reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Decompile {
  public static void main(String[] args) throws ClassNotFoundException {
    StringBuilder s = new StringBuilder();
    Class test = Class.forName("java.lang.String");
    Field[] test1 = test.getDeclaredFields();

    s.append(
        Modifier.toString(test.getModifiers()) + " class " + test.getSimpleName() + " " + "{\n");
    ;

    for (Field field : test1) {
      s.append(
          Modifier.toString(field.getModifiers())
              + " "
              + field.getType().getSimpleName()
              + " "
              + field.getName()
              + "\n");
    }

    s.append(" }");

    System.out.println(s);
  }
}

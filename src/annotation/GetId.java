package annotation;

import java.lang.reflect.Field;

public class GetId {
  public static void main(String[] args) throws ClassNotFoundException {
    Class c = Class.forName("Amarry.Student");

    if (c.isAnnotationPresent(ID.class)) {
      Boolean b = false;
      Field[] field = c.getDeclaredFields();
      for (Field fields : field) {
        if ("id".equals(fields.getName()) && "int".equals(fields.getType().getSimpleName())) {
          b = true;
        }
      }
      if (!b) {
        throw new AnnotationException("没有ID注解");
      }
    }
  }
}

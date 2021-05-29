package reflex;

import java.lang.reflect.Field;

public class CallReflectionGain {
  public static void main(String[] args)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException,
          NoSuchFieldException {
    Class<?> s = Class.forName("reflex.Test01");
    Object obj = s.newInstance();

    Field f = s.getDeclaredField("name");

    f.setAccessible(true);

    System.out.println(f.get(obj));
    f.set(obj, "张三");
    System.out.println(f.get(obj));
    ;
  }
}

package reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallMethod {
  public static void main(String[] args)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException,
          NoSuchMethodException, InvocationTargetException {
    Class c = Class.forName("reflex.SystemLoginClass");
    Object obj = c.newInstance();
    Method m = c.getDeclaredMethod("longin", String.class, String.class);

    System.out.println(m.invoke(obj, "123", "233"));
  }
}

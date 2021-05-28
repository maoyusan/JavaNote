package reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CallNoArgumentConstruct {
  public static void main(String[] args)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException,
          NoSuchMethodException, InvocationTargetException {
    Class c = Class.forName("reflex.SystemLoginClass");
    Object obj = c.newInstance();
    System.out.println(obj);
    Constructor con = c.getDeclaredConstructor(int.class, int.class);
    Object newobj = con.newInstance(2, 4);
    System.out.println(newobj);
  }
}

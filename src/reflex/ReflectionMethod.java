package reflex;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionMethod {
  public static void main(String[] args) throws ClassNotFoundException {
    Class c = Class.forName("reflex.SystemLoginClass");
    Method[] methods = c.getDeclaredMethods();
    for (Method method : methods) {
      System.out.println(
          Modifier.toString(method.getModifiers())
              + " "
              + method.getReturnType()
              + " "
              + method.getName());

      Class[] c1 = method.getParameterTypes();
      for (Class o : c1) {
        System.out.print(" " + o.getSimpleName());
      }
    }
  }
}

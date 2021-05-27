package reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ConstructionMethod {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
    StringBuilder s = new StringBuilder();

    Class c = Class.forName("java.lang.String");
    System.out.print(Modifier.toString(c.getModifiers()));
    System.out.print(" class ");
    System.out.print(c.getSimpleName());
    s.append(" ");
    s.append("{\n");
    /*构造创建构造方法的参数，然后开始遍历*/
    Constructor[] c1 = c.getConstructors();
    for (Constructor constructor : c1) {
      s.append(Modifier.toString(constructor.getModifiers()));
      s.append(" " + c.getSimpleName() + " ");
      /*构造方法 就是类名！*/
      Class[] p = constructor.getParameterTypes();
      s.append("(");
      /*遍历构造方法的类型*/
      for (Class par : p) {
        s.append(par.getSimpleName());
        s.append(",");
      }
      if (p.length > 0) {
        s.deleteCharAt(s.length() - 1);
      }
      s.append(")");
      s.append("{}\n");
    }

    s.append("\n}");
    System.out.println(s);
  }
}

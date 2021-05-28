package annotation;

import java.lang.reflect.Method;

public class Note01 {
  @note(username = "2333", password = "123")
  public void dosome() {}

  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
    Class c = Class.forName("annotation.Note01");
    Method m = c.getMethod("dosome");
    if (m.isAnnotationPresent(note.class)) {
      note note = m.getAnnotation(note.class);
      System.out.println(note.username());
      System.out.println(note.password());
    }
  }
}

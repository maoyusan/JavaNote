package reflex;

public class Args01 {
  public static void main(String[] args) {
    main(1, "hello", "word");
  }

  public static void main(int a, String... args) {
    System.out.println(a);
    for (Object o : args) {
      System.out.println(o);
    }
  }
}

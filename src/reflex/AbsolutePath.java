package reflex;

import java.util.Objects;

public class AbsolutePath {
  public static void main(String[] args) {
    String path =
        Objects.requireNonNull(
                Thread.currentThread().getContextClassLoader().getResource("reflex/t.Properties"))
            .getPath();

    System.out.println(path);
  }
}

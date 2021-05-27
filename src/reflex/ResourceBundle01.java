package reflex;

import java.util.ResourceBundle;

public class ResourceBundle01 {
  public static void main(String[] args) {
    ResourceBundle r = ResourceBundle.getBundle("reflex/t");
    System.out.println(r.getString("classname"));
  }
}

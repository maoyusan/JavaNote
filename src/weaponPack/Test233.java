package weaponPack;

public class Test233 {
  public static void main(String[] args) {
    Testa a = new Testa();
    a.new Ab().a();

    Testa.Ab c = new Testa().new Ab();
    c.a();

    new Testa().new Ab().a();
  }
}

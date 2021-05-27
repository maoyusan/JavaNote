package weaponPack;

public class Test {
  public static void main(String[] args) {
    Weapon.Rocket rocket = new Weapon.Rocket();
    Weapon.Airplane airplane = new Weapon.Airplane();
    Army army = new Army(2);

    try {
      army.addWeapon(rocket);
      army.addWeapon(airplane);
    } catch (overflowException e) {

      System.out.println(e.getMessage());
    }
    army.attackAll();
    army.moveAll();
  }
}

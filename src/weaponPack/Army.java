package weaponPack;

public class Army {

  private final Weapon[] weapons;

  Army(int count) {
    weapons = new Weapon[count];
  }

  public void addWeapon(Weapon weapon) throws overflowException {
    for (int i = 0; i < weapons.length; i++) {
      if (null == weapons[i]) {
        weapons[i] = weapon;
        return;
      }
    }
    throw new overflowException("满异常");
  }

  public void attackAll() {
    for (Weapon weapon : weapons) {
      if (weapon instanceof Shooting) {
        Shooting s = (Shooting) weapon;
        s.attack();
      }
    }
  }

  public void moveAll() {
    for (Weapon weapon : weapons) {
      if (weapon instanceof Move) {
        Move move = (Move) weapon;
        move.move();
      }
    }
  }
}

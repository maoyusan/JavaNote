package weaponPack;

public class Weapon {
  public static class Rocket extends Weapon implements Move, Shooting {
    @Override
    public void move() {
      System.out.println("火箭在移动");
    }

    @Override
    public void attack() {
      System.out.println("火箭在射击");
    }
  }

  public static class Airplane extends Weapon implements Move, Shooting {
    @Override
    public void move() {
      System.out.println("运输机飞机在飞");
    }

    @Override
    public void attack() {
      System.out.println("运输机不会攻击！");
    }
  }

  public static class MachineGun extends Weapon implements Move, Shooting {
    @Override
    public void move() {
      System.out.println("机枪在移动 ");
    }

    @Override
    public void attack() {
      System.out.println("机枪在射击");
    }
  }
}

package javawork;

public abstract class Dog {
  abstract void feed();
}

class Master extends Dog {
  @Override
  void feed() {
    System.out.println("狗子在开心跳");
  }
}

class Stranger extends Dog {
  @Override
  void feed() {
    System.out.println("狗子在警惕");
  }
}

class Family extends Dog {
  @Override
  void feed() {
    System.out.println("狗在正常吃东西");
  }
}

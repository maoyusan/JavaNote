package javawork;

public abstract class Teacher {
  abstract void ask();
}

class StudentA extends Teacher {
  @Override
  void ask() {
    System.out.println("学生A回答了第一个问题");
  }
}

class StudentB extends Teacher {

  @Override
  void ask() {
    System.out.println("学生B回答了第二个问题");
  }
}

class StudentC extends Teacher {

  @Override
  void ask() {
    System.out.println("学生C回答了第三个问题");
    ;
  }
}

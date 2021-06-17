package javawork;

public class Test {
  public static void main(String[] args) {
    Dog master = new Master();
    Dog stranger = new Stranger();
    Dog family = new Family();
    master.feed();
    stranger.feed();
    family.feed();

    Teacher studentA = new StudentA();
    Teacher studentB = new StudentB();
    Teacher studentC = new StudentC();
    studentA.ask();
    studentB.ask();
    studentC.ask();
    //
  }
}

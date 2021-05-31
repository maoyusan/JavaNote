package PQ;

import java.util.Scanner;

public class TestWine {
  Room[][] rooms = new Room[3][3];

  public static void main(String[] args) {

    TestWine testWine = new TestWine();
    testWine.startTest();
    Scanner scanner = new Scanner(System.in);
    System.out.println("欢迎使用酒店管理系统！");
    for (; ; ) {
      System.out.println("查房 请按1");
      System.out.println("订房 请按2");
      System.out.println("退房 请按3");
      int b = scanner.nextInt();
      switch (b) {
        case 1:
          testWine.chaFang();
          break;
        case 2:
          testWine.dingFang();
          break;
        case 3:
          testWine.tuiFang();
          break;
        default:
          System.exit(0);
      }
    }
  }

  public void startTest() {
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        if (i == 0) {
          rooms[i][j] = new Room((i + 1) * 100 + j + 1, true, "单人房");
        }
        if (i == 1) {
          rooms[i][j] = new Room((i + 1) * 100 + j + 1, true, "大房间");
        }
        if (i == 2) {
          rooms[i][j] = new Room((i + 1) * 100 + j + 1, true, "总统房");
        }
      }
    }
  }

  public void chaFang() {
    for (Room[] room : rooms) {
      for (Room value : room) {
        System.out.println(value.number + value.type + ":" + (value.status ? "空闲" : "占用"));
      }
    }
  }

  public void dingFang() {
    Scanner in = new Scanner(System.in);
    System.out.println("请选择您要的房间类型");
    System.out.println("单人间 请按0");
    System.out.println("情侣间 请按1");
    System.out.println("豪华间 请按2");
    int a = in.nextInt();
    for (int i = 0; i < rooms[a].length; i++) {
      if (rooms[a][i].status) {
        System.out.println("订房成功！");
        System.out.println("您的房间信息为" + rooms[a][i].number + rooms[a][i].type);
        rooms[a][i].status = false;
        return;
      }
    }
    System.out.println("订房失败！房间已经满！");
  }

  public void tuiFang() {
    Scanner in = new Scanner(System.in);
    System.out.println("请输入您要退的房间号");
    int a = in.nextInt();
    if (rooms[a / 100 - 1][a % 100 - 1].status) {
      System.out.println("房间未使用，或无该房间，请重试！");
    }
    if (!rooms[a / 100 - 1][a % 100 - 1].status) {
      rooms[a / 100 - 1][a % 100 - 1].status = true;
      System.out.println("退房成功！");
    }
  }
}

class Room {
  int number;
  boolean status;
  String type;

  public Room(int number, boolean status, String type) {
    this.number = number;
    this.status = status;
    this.type = type;
  }

  @Override
  public String toString() {
    return "Room{" + "number=" + number + ", status=" + status + ", type='" + type + '\'' + '}';
  }
}

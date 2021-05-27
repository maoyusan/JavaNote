package Iotest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemFlow {
  public static void main(String[] args) {
    SystemFlow.log("这是一个清凉的夏天");
  }

  public static void log(String msg) {
    try {
      PrintStream out = new PrintStream(new FileOutputStream("log.txt"));
      System.setOut(out);
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      System.out.println(sdf.format(date) + ":" + msg);
      out.flush();
      out.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}

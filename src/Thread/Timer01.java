package Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Timer01 {
  public static void main(String[] args) {
    Timer timer = new Timer();
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date firsttime = null;
    try {
      firsttime = sdf.parse("2021-5-26 11:59:30");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    timer.schedule(
        new TimerTask() {
          @Override
          public void run() {
            System.out.println(sdf.format(date) + "备份成功");
          }
        },
        firsttime,
        1000 * 5);
  }
}

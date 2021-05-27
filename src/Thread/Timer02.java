package Thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Timer02 {
  public static void main(String[] args) {
    ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date f = sdf.parse("2021-5-26");

    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}

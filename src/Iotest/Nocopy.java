package Iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Nocopy {
  public static void main(String[] args) {

    try {
      FileInputStream fis = null;
      FileOutputStream fos = null;
      byte[] bytes = new byte[1024];
      File file1 = new File("D:\\笔记");

      if (!file1.exists()) {
        System.out.println("文件不存在！");
        System.exit(0);
      }

      File file2 = new File("D:\\拷贝文件夹");

      if (!file2.exists()) {
        file2.mkdir();
      }

      File[] files = file1.listFiles();

      int counter;
      for (File file : files) {

        fis = new FileInputStream(file);

        fos = new FileOutputStream(file2 + "\\" + file.getName());
        while ((counter = fis.read(bytes)) != -1) {
          fos.write(bytes, 0, counter);
          fos.flush();
        }
      }
      assert fos != null;

      fis.close();
      fos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

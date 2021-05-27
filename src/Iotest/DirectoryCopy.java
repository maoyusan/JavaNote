package Iotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DirectoryCopy {
  public static void main(String[] args) {
    //    放入源文件
    File src = new File("D:\\html网页设计");
    //    放入目标文件
    File copyDir = new File("C:\\");
    //    调用拷贝方法
    copy(src, copyDir);
  }

  public static void copy(File src, File copyDir) {
    /*判断是否为文件不是就跳过继续往下递归，是则递归结束返回*/
    if (src.isFile()) {
      //      一边读一边写
      FileInputStream fis = null;
      FileOutputStream fos = null;
      try {
        /*放入要读的文件*/
        fis = new FileInputStream(src);
        String pathAfter = src.getAbsolutePath().substring(3);
        String srcPath = copyDir.getAbsolutePath();
        fos =
            new FileOutputStream(
                srcPath.endsWith("//") ? srcPath + pathAfter : srcPath + pathAfter + "\\");
        byte[] bytes = new byte[1024 * 1024];
        int counter;
        while ((counter = fis.read(bytes)) != -1) {
          fos.write(bytes, 0, counter);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      return;
    }
    //    创建一个文件数组对象，将列表所有的路径放进去
    File[] files = src.listFiles();
    //    遍历该数组里面的所有文件
    for (File file : files) {
      //      判断文件的内容是否为目录
      if (file.isDirectory()) {
        //        获取源目录绝对路径，截掉前面三个字段，放入一个新String对象里
        String pathAfter = file.getAbsolutePath().substring(3);
        //        获取获取拷贝路径
        String targetPath =
            copyDir.getAbsolutePath().endsWith("\\")
                ? copyDir.getAbsolutePath() + pathAfter
                : copyDir.getAbsolutePath() + "\\" + pathAfter;
        System.out.println(targetPath);
        //        判断文件是否存在，false则创建多个目录
        if (!new File(targetPath).exists()) {
          new File(targetPath).mkdirs();
        }
      }
      //      for循环递归每个目录，通过上面的判断遍历所有目录
      copy(file, copyDir);
    }
  }
}

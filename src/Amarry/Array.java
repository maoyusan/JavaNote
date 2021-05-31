package Amarry;

import java.util.*;

public class Array {
  public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<String>();
    arrayList.add("张三");
    LinkedList linkedList = new LinkedList();
    linkedList.add("李四");
    HashSet set = new HashSet();
    set.add("hello");
    HashMap hashMap = new HashMap();
    hashMap.put(1, "张三");
    Iterator it = arrayList.iterator();

    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}

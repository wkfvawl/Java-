//7.28��ѧ�����
import java.util.*;
//import java.util.List;

public class Exercise07_28 {

  public static void main(String[] args) {
    int[] a = new int[10];
    List<String> lists = new ArrayList<String>();//ʹ��list�洢���
    Scanner cin = new Scanner(System.in);
    System.out.print("������ʮ������ ");
    for (int i = 0; i < 10; i++) {// ѭ������10����
      a[i] = cin.nextInt();
    }
    System.out.println("���е���Ϲ��ã�");
    for (int i = 0; i < 10; i++) {
      for (int j = i + 1; j < 10; j++)
        lists.add(a[i] + " " + a[j] + "");
    }
    for (int i = 0; i < lists.size() - 1; i++) {//listȥ��
      for (int j = lists.size() - 1; j > i; j--) {
        if (lists.get(j).equals(lists.get(i))) {
          lists.remove(j);
        }
      }
    }
    Iterator<String> it = lists.iterator();
    while (it.hasNext()) {
      System.out.println(it.next() + " ");
    }
  }
}
//5.33 ��ȫ��
import java.util.*;
public class Exercise05_33 {
  public static void main(String[] args) {
    for (int i = 1; i <= 10000; i++) {//����1000�ڵ���
      int sum = 0;
      for (int j = 1; j < i; j++) {//�ҵ����еĳ���
        if (i % j == 0) {
          sum += j;
        }
      }
      if (sum == i) {
        System.out.println("��ȫ����"+i);
      }
    }
  }
}
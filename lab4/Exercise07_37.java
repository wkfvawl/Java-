//7.37��Ϸ������
import java.util.*;

public class Exercise07_37 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int m, n;
    System.out.print("Enter the number of balls to drop:");
    m = cin.nextInt();// ������ĸ���
    System.out.print("Enter the number of slots in the bean machine:");
    n = cin.nextInt();// �������������
    int[] slots = new int[n];
    char[] path = new char[n];// ����·��
    System.out.println("");
    System.out.println("");
    for (int i = 0; i < m; i++) {
      int cnt = 0;
      for (int j = 0; j < n - 1; j++) {
        int opt = (int) (Math.random() * 2);// �������0��1
        if (opt == 0) {// ��
          path[j] = 'L';
        } else {// ��
          path[j] = 'R';
          cnt++;// R�ĸ������ô�������һ������
        }
      }
      slots[cnt]++;// ��¼�����ڵ���
      System.out.println(path);// ��ӡ·��
    }
    int maxs = 0;// ������ຬ�е�С����
    for (int i = 0; i < n; i++) {
      if (slots[i] > maxs) {
        maxs = slots[i];
      }
    }
    System.out.println();
    for (int i = 0; i < maxs; i++) {//�����������������
      for (int j = 0; j < n; j++) {//�ж�ÿһ����λ
        if (slots[j] >= (maxs - i)) {
          System.out.print("0");// ����0��ʾ
        } else {
          System.out.print(" ");// ����0��ʾ
        }
      }
      System.out.println();
    }
  }
}
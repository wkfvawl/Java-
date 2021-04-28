//8.17���ڷ籩
import java.util.*;
public class Exercise08_17 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    double[] balances = new double[n]; // �������
    double[][] borrowers = new double[n][n]; // ����i���������j�Ĵ�����
    double[] asset = new double[n]; // �������ʲ�
    boolean[] judgement = new boolean[n]; // �����Ƿ�ȫ
    double limit = cin.nextDouble(); // �������а�ȫ����С���ʲ�
    for (int i = 0; i < n; i++) {
      balances[i] = cin.nextDouble();
      int num = cin.nextInt();
      for (int j = 0; j < num; j++) {
        int borrowerId = cin.nextInt();// ��id
        borrowers[i][borrowerId] = cin.nextDouble();
      }
    }

    for (int i = 0; i < n; i++) {// ��ʼ�������е����ж��ǰ�ȫ��
      judgement[i] = true;
    }
    boolean flag = true;

    while (flag) {
      flag = false;
      for (int i = 0; i < n; i++) {
        asset[i] = balances[i];
        for (int j = 0; j < n; j++) {
          asset[i] += borrowers[i][j];
        }
        if (judgement[i] && asset[i] < limit) {// ���в���ȫ
          judgement[i] = false;
          for (int j = 0; j < n; j++) {// ����ȫ���е��½�������ܽ��ʲ����������ʲ�
            borrowers[j][i] = 0;
          }
          flag = true;
        }
      }
    }
    System.out.print("Unsafe banks: ");
    for (int i = 0; i < n; i++) {
      if (!judgement[i]) {
        System.out.print(i+" ");
      }
    }
  }
}


/*
5 201
25 2 1 100.5 4 320.5
125 2 2 40 3 85
175 2 0 125 3 75
75 1 0 125
181 1 2 125
Unsafe banks: 1 3*/

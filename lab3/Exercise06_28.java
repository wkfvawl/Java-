//6.28 ÷������
import java.util.*;
public class Exercise06_28 {
  public static boolean isPrime(int num) {//�ж��Ƿ�Ϊ����
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    for (int i = 2; i <= 31; i++) {//����ö��
      int a = (int) (Math.pow(2, i) - 1);//÷�ֱ��ʽ
      if (isPrime(a)) {
        System.out.println("÷�������У�" + a);
      }
    }
  }
}
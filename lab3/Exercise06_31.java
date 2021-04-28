//6.31 ����Ӧ�ã����ÿ��ŵĺϷ�����֤
import java.util.*;
public class Exercise06_31 {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter a credit card number as a long integer: ");
    long number = cin.nextLong();
    if (isValid(number)) {
      System.out.println(number + " is valid");
    } else {
      System.out.println(number + " is invalid");
    }
  }

  // �ж����п����Ƿ�Ϸ�
  public static boolean isValid(long number) {
    if ((getSize(number) >= 13) && (getSize(number) <= 16)) {// 13��16λ������
      if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 6)
          || prefixMatched(number, 37)) {// ��ͷǰ׺��Ҫ����Ҫ�������
        int evenSum = sumOfDoubleEvenPlace(number);
        int oddSum = sumOfOddPlace(number);
        if ((evenSum + oddSum) % 10 == 0) {
          return true;
        }
      }
    }
    return false;
  }

  // ���ż��λ������֮��
  public static int sumOfDoubleEvenPlace(long number) {
    int ans = 0;
    int temp;
    number = number / 10;
    while (number != 0) {
      temp = (int) ((number % 10) * 2);
      if (temp > 9) {// ���ַ���֮��������λ��
        temp = getDigit(temp);
      }
      ans += temp;
      number = number / 100;
    }
    return ans;
  }

  // ��λ���ĸ�λ֮��
  public static int getDigit(int number) {
    int ans;
    ans = number / 10 + number % 10;
    return ans;
  }

  // ԭ����������λ֮��
  public static int sumOfOddPlace(long number) {
    int ans = 0;
    int temp;
    while (number != 0) {
      temp = (int) (number % 10);
      ans += temp;
      number = number / 100;
    }
    return ans;
  }

  // ǰ׺ƥ��
  public static boolean prefixMatched(long number, int d) {
    if (d == getPrefix(number, getSize(d))) {
      return true;
    } else {
      return false;
    }
  }

  // ���ֵ�λ��
  public static int getSize(long d) {
    int cnt = 0;
    while (d != 0) {
      d = d / 10;
      cnt++;
    }
    return cnt;
  }

  // ���ǰ׺��ǰkλ
  public static long getPrefix(long number, int k) {
    if(k>getSize(number))
    {
      return number;
    }
    int i = getSize(number) - k;
    while (i != 0) {
      number /= 10;
      i--;
    }
    return number;
  }
}
// 4388576018410707 is valid
// 4388576018402626 is invalid
//2.13 ����Ӧ�ã�����ֵ
import java.util.*;
public class Exercise02_13 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the monthly saving amount: ");
        double accout = cin.nextDouble();
        double sum = 0;
        //ʹ��ѭ����
        for(int i = 1; i <= 6; i++) {
            sum = (accout + sum) * 1.00417;
        }
        System.out.println("After the sixth month, the account value is $" + String.format("%.2f", sum));
        //String.format("%.2f", sum) ����С�������λ
    }
}
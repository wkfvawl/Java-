//4.26 ����Ӧ�ã����ҵ�λ
import java.util.*;
public class Exercise04_26 {
    
    public static void main(String args[]) {
        Scanner cin=new Scanner(System.in);
        System.out.print("Enter an amount in String ,for example 11.56:");
        String amount = cin.nextLine();//�ַ�������,��StringתΪint
        int pos=amount.indexOf('.');
        String s1=amount.substring(0,pos);//��ȡ�������� ��Ϊ��Ԫ������
        String s2=amount.substring(pos+1,amount.length());//��ȡС�����֣���Ϊ���ֵ�����
        int sum1=0;
        int sum2=0;;
        for(int i = 0;i < s1.length();i++){//�����Ԫ
            sum1 = sum1 * 10;
            sum1 += (int)(s1.charAt(i)-48);
        }
        for(int j = 0;j < 2;j++){//�������,ֻ����С��������λ
            sum2 = sum2 * 10;
            sum2 += (int)(s2.charAt(j)-48);
        }
        //̰�Ĳ���
        int remain = sum1 * 100 + sum2;
        int OneDollars = remain / 100;
        remain = remain % 100;
        int Quarters = remain / 25;
        remain = remain % 25;
        int Dimes = remain / 10;
        remain = remain % 10;
        int Nickels = remain / 5;
        remain = remain % 5;
        int Pennies = remain;
        System.out.println("Your amount "+amount+" consists of");
        System.out.println("    "+OneDollars+" dollars");
        System.out.println("    "+Quarters+" quarters");
        System.out.println("    "+Dimes+" dimes");
        System.out.println("    "+Nickels+" nickels");
        System.out.println("    "+Pennies+" pennies");
    }      
}
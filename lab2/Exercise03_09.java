//3.9 ��ҵ������ISBN-10
import java.util.*;
public class Exercise03_09 {
    
    public static void main(String args[]) {
        Scanner input= new Scanner(System.in);
        int []a = new int[10];
        int ans = 0;
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        int n = input.nextInt();//��ȡһ����������
        for(int i = 9;i >= 1;i--){//�������
            a[i]=n % 10;
            n=n / 10;
        }
        for(int i = 1;i <= 9;i++){
            ans += a[i]*i;
        }
        ans=ans % 11;
        System.out.print("The ISBN-10 number is ");
        for(int i = 1;i <= 9;i++){
            System.out.print(a[i]);
        }
        if(ans == 10){
            System.out.println("X");
        }
        else{
            System.out.println(ans);
        }
    }
}
//4.25 ���ɳ��ƺ���
import java.util.*;
public class Exercise04_25 {
    
    public static void main(String args[]) {
        char c;
        int x;
        System.out.print("��������ĳ��ƺ�Ϊ��");
        for(int i = 0;i < 3;i++){//ǰ��λ��д��ĸ
            c = (char)(int)(Math.random() * 26 + 65);
            System.out.print(c);
        }
        System.out.print("-");
        for(int i = 0;i < 4;i++){//����λ����
            x=(int)(Math.random() * 10 );
            System.out.print(x);
        }
            
    }      
}
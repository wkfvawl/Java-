// 1.11�˿ڼ���
import java.util.*;
public class Exercise01_11 {
    public static void main(String[] args){
        int org = 312032486;             //��ǰ�˿�
        int sec = 365 * 24 * 60 * 60;    //һ��֮�е�����
        double birth = sec / 7.0;        //����
        double death = sec / 13.0;       //���� 
        double img = sec / 45.0;         //Ǩ��
        int sum = (int)(birth - death + img);    
        int years;
        //ʹ��ѭ����
        for(int i = 1 ;i <= 5; i++)
        {
            years = org + i * sum;
            System.out.println(years);
        }   
    }
}
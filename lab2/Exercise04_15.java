//4.15 �绰����
import java.util.*;
public class Exercise04_15 {
    
    public static void main(String args[]) {
        String[]telmap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};//����mapӳ��
        String letter;
        char c;
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter a letter :");
        letter = cin.nextLine();
        c = letter.charAt(0);
        if((c >='a'&&c <='z')||(c >='A'&&c <='Z')){
            c = Character.toLowerCase(c);//ͳһΪСд��ʽ
            for(int i = 0;i< 10;i++){//ѭ������telmap
                int pos = telmap[i].indexOf(c);
                if(pos != -1){
                    System.out.println("The corresponding number is "+i);
                    break;    
                }
            }
        }
        else{
            System.out.println(letter+" is an invalid input");
        }
    }      
}
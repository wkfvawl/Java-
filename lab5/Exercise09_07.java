//9.7(Account��)
import java.util.*;

//java.util.Date ����Data��
class Account {
    private int id;// �˺�
    private double balance;// ���
    private static double annualInterestRate;// ��ǰ����
    private Date dateCreated;// ��������

    public Account() {
        dateCreated = new Date();
    }// �޲ι��췽��

    public Account(int newId, double newBalance) {
        id = newId;
        balance = newBalance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        id = newId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }// ���õ�ǰ����

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }// ���ص�ǰ����

    public double getMonthlyInterestRate() {
        return annualInterestRate / (12 * 100);
    }// ����������

    public double getMonthlyInterest() {
        return balance * (annualInterestRate / (12 * 100));
    }// ��������Ϣ

    public Date getDateCreated() {
        return dateCreated;
    }// dateCreated����������

    public void withdraw(double amount) {
        balance -= amount;
    }// ��ȡָ�����

    public void deposit(double amount) {
        balance += amount;
    }// �洢ָ�����

}

public class Exercise09_07 {
    // ���Գ���
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);// ������4.5
        account.withdraw(2500);// ȡ��2500
        account.deposit(3000);// ���3000
        double nowBalance = account.getBalance();
        double nowAnnualInterest = account.getMonthlyInterest();
        double nowAnnualInterestRate = account.getMonthlyInterestRate();
        Date DateCreated = account.getDateCreated();
        System.out.println("�˺�����У�" + nowBalance );
        System.out.println("����Ϣ��:" + nowAnnualInterest );
        System.out.println("���˺Ŵ�����" + DateCreated );
    }
}
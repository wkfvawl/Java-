//10.7(��Ϸ��ATM��)
import java.util.*;

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

// ���Գ���
public class Exercise10_07 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Account[] accounts = new Account[10];// 10���˻�����
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i,100);
        }//��ʼ������
        int id;
        int choice;
        while (true) {
            System.out.print("Enter an id: ");
            id = cin.nextInt();
            if (id < 1 || id > 10) {
                System.out.println("�����id������������ȷ��id:");
                continue;
            }
            while (true) {
                System.out.println(" ");
                System.out.println("Main menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                choice = cin.nextInt();
                if (choice == 1) {
                    System.out.println("The balance is " + accounts[id].getBalance());

                } else if (choice == 2) {
                    System.out.print("Enter an amount to withdraw: ");
                    int amount = cin.nextInt();
                    if (amount <= accounts[id].getBalance()) {
                        accounts[id].withdraw(amount);
                    } else {
                        System.out.println("���㣡");
                    }
                } else if (choice == 3) {
                    System.out.print("Enter an amount to deposit: ");
                    int amount = cin.nextInt();
                    if (amount >= 0) {
                        accounts[id].deposit(amount);
                    } else {
                        System.out.print("Ҫ����Ľ��Ϸ������������룡");
                    }
                } else if (choice == 4) {
                    break;

                } else {
                    System.out.println("����������������룺");
                }
            }
        }
    }
}
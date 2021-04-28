//11.8�µ�Account��
import java.util.*;

class Account {
  private int id; // �˺�
  private double balance; // ���
  private static double annualInterestRate;
  // ��ǰ����,ע��������static,Ҫ�����и���Ķ�����Ч
  private Date dateCreated; // ��������
  private String name; // �ͻ�����
  private ArrayList<Transaction> transactions;//�洢�˻����׵Ķ�̬�б�

  public Account() {
    dateCreated = new Date();
  }// �޲ι��췽��

  public Account(String newName, int newId, double newBalance) {
    name = newName;
    id = newId;
    balance = newBalance;
    dateCreated = new Date();
    transactions = new ArrayList<Transaction>();// ���������洢�˻�����
  }// ���캯������ָ��������id�������˺�

  public String getName() {
    return name;
  }

  public ArrayList getTransactions() {
    return transactions;
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
    transactions.add(new Transaction('W', amount, balance, ""));
  }// ��ȡָ�����

  public void deposit(double amount) {
    balance += amount;
    transactions.add(new Transaction('D', amount, balance, ""));
  }// �洢ָ�����
}

class Transaction {

  private java.util.Date date;
  private char type; // ��������
  private double amount;// ������
  private double balance; // ���׺�������
  private String description;// ��������

  public Transaction(char newType, double newAmount, double newBalance, String newDescription) {
    date = new Date();
    type = newType;
    amount = newAmount;
    balance = newBalance;
    description = newDescription;
  }

  public Date getDate() {
    return date;
  }

  public char getType() {
    return type;
  }

  public void setType(char newType) {
    type = newType;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double newAmount) {
    amount = newAmount;
  }

  public double getBalance() {
    return balance;
  }

  public double setBalance(double newBalance) {
    balance = newBalace;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String newDescription) {
    description = newDescription;
  }
}

public class Exercise11_08 {
  public static void main(String[] args) {
    Account testAccount = new Account("George", 1112, 1000.0);
    Account.setAnnualInterestRate(1.5);
    
    testAccount.deposit(30);
    testAccount.deposit(40);
    testAccount.deposit(50);// ��Ǯ����

    testAccount.withdraw(5);
    testAccount.withdraw(4);
    testAccount.withdraw(2);// ȡǮ����

    System.out.println("�˻�������" + testAccount.getName());
    System.out.println("������: " + Account.getAnnualInterestRate());
    System.out.println("�˻����: " + testAccount.getBalance());

    for (int i = 0; i < testAccount.getTransactions().size(); i++) {
      Transaction transaction = (Transaction) testAccount.getTransactions().get(i);
      System.out.printf("%-35s%-15s%-15s%-15s\n", transaction.getDate(), transaction.getType(), transaction.getAmount(),
          transaction.getBalance());
    }
  }
}
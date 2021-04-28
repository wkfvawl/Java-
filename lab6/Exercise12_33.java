//12.33(���� Web)
import java.util.*;
import java.net.URL;

public class Exercise12_33 {// ��������
  public static void main(String[] args) {
    Scanner input = new java.util.Scanner(System.in);
    System.out.print("��������ʼ��վ��URL: ");
    String url = input.nextLine();
    System.out.print("������Ҫ���ҵĵ���: ");
    String word = input.nextLine();
    crawler(url, word); // ����ʼ��url��ʼ��ȡword
  }

  public static void crawler(String startingURL, String word) {
    ArrayList<String> listOfPendingURLs = new ArrayList<>();// ������������ַ�б�
    ArrayList<String> listOfTraversedURLs = new ArrayList<>();// �Ѿ���������ַ�б�
    listOfPendingURLs.add(startingURL);
    // ����100��URL
    while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
      // ��Ҫ�������б�Ϊ�գ��Ѿ��������б��ģС��100
      String urlString = listOfPendingURLs.remove(0);// �ӽ�Ҫ�������б����Ƴ���һ��
      if (!listOfTraversedURLs.contains(urlString)) {
        // �����URL�����Ѿ��������б���
        listOfTraversedURLs.add(urlString);
        // �ͼ��뵽�Ѿ��������б���
        System.out.println("Craw " + urlString);

        if (contains(urlString, word)) {
          System.out.println("The URL " + urlString + " contains the word " + word);
          System.out.println("The number of pages been searched is " + listOfTraversedURLs.size());
          break;
        }

        for (String s : getSubURLs(urlString)) {
          if (!listOfTraversedURLs.contains(s))
            listOfPendingURLs.add(s);
        }
      }
    }
  }

  // ����urlString��վ���Ƿ��е���word
  public static boolean contains(String urlString, String word) {
    try {
      URL url = new URL(urlString);
      try (Scanner input = new Scanner(url.openStream())) {
        // ���������ж�ȡ����
        while (input.hasNext()) {
          String line = input.nextLine();
          if (line.indexOf(word) > 0) {
            return true;
          } // �ַ����а���Ҫ�ҵĵ��ʣ����ҳɹ�
        }
      }
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }

    return false;
  }

  // ������ȡҳ���е�����URL�ĺ���
  public static ArrayList<String> getSubURLs(String urlString) {
    ArrayList<String> list = new ArrayList<>();
    try {
      URL url = new URL(urlString);
      Scanner input = new Scanner(url.openStream());
      int current = 0;
      while (input.hasNext()) {
        String line = input.nextLine();
        current = line.indexOf("http:", current);
        while (current > 0) {
          int endIndex = line.indexOf("\"", current);
          if (endIndex > 0) { // Ensure that a correct URL is found
            list.add(line.substring(current, endIndex));
            current = line.indexOf("http:", endIndex);
          } else
            current = -1;
        }
      }
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }
    return list;
  }
}
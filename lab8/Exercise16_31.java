import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javax.lang.model.util.ElementScanner6;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
//Duration��������¼�

// ��װ����
class BoardPane extends GridPane {
  // ��װ����
  class Pieces extends Circle {
    // �����������е�λ��
    int i;
    int j;

    public Pieces(int i, int j) {
      super(10, 10, 20);// Բ������
      this.setFill(Color.WHITE);// �����ɫ
      this.setStroke(Color.BLACK);// �߿���ɫ
      this.i = i;
      this.j = j;
      this.setOnMousePressed(e -> {
        if (available(i, j)) {
          if (cnt % 2 == 0) {
            board[i][j] = 'Y';
            this.setFill(Color.YELLOW);
            cnt++;
            if (judgement()) {
              System.out.println("Yellow win!");
              flashAnimation.play();
            }
            if (isDraw()) {
              System.out.println("A draw, no winner, start over");
            }

          } else if (cnt % 2 == 1) {
            board[i][j] = 'R';
            this.setFill(Color.RED);
            cnt++;
            if (judgement()) {
              System.out.println("Red win!");
              flashAnimation.play();
            }
            if (isDraw()) {
              System.out.println("A draw, no winner, start over");
            }
          }

        }
      });
    }

    // �ж������������ϵ�λ���Ƿ����
    private boolean available(int i, int j) {
      return (board[i][j] == '\u0000' && (i == 5 || board[i + 1][j] != '\u0000'));
    }
  }

  private Pieces[][] pieces = new Pieces[6][7];
  private int cnt = 0;// ����˫���ļ�����
  char[][] board = new char[6][7];
  private Timeline flashAnimation = new Timeline(new KeyFrame(Duration.millis(500), e -> {
    flashing();
  }));
  /*
   * �����������ķ�ʽ 1 �� 2 �� 3 ���Խ��� 4 ���Խ���
   */
  int model;
  int x;
  int y;//�����������ĵ�һ����������
  int flag;//������˸�ı���
  public BoardPane() {
    this.setAlignment(Pos.CENTER);
    // ˮƽ��ֱ���Ϊ5
    this.setHgap(5);
    this.setVgap(5);
    this.setStyle("-fx-background-color:#c6ced4");
    flashAnimation.setCycleCount(Timeline.INDEFINITE);
    this.x = 0;
    this.y = 0;
    this.model = 0;
    this.flag = 0;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        pieces[i][j] = new Pieces(i, j);
        this.add(pieces[i][j], j, i);
        board[i][j] = '\u0000';
      }
    }
  }

  // �ж��Ƿ����ƽ��
  public boolean isDraw() {
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 7; j++) {
        if (board[i][j] == '\u0000') {
          return false;
        }
      }
    }
    return true; // ���������е�λ�ö���ռ��
  }

  // �ж��Ƿ������е�Ԫ���Ƿ�ȫ����ͬ
  public boolean judgement() {
    // �ж����Ƿ���������
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] != '\u0000') {
          if (board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3]) {
            x = i;
            y = j;
            model = 1;
            return true;
          }
        }
      }
    }
    // �ж����Ƿ���������
    for (int j = 0; j < 7; j++) {
      for (int i = 0; i < 3; i++) {
        if (board[i][j] != '\u0000') {
          if (board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] == board[i + 3][j]) {
            x = i;
            y = j;
            model = 2;
            return true;
          }
        }
      }
    }

    // �ж����Խ����°벿���Ƿ���������
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 6 - i; j++) {
        if (board[i][j] != '\u0000') {
          if (board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2]
              && board[i][j] == board[i + 3][j + 3]) {
            x = i;
            y = j;
            model = 3;
            return true;
          }

        }
      }
    }

    // �ж����Խ����ϰ벿���Ƿ���������
    for (int j = 1; j < 4; j++) {
      for (int i = 0; i < 4 - j; i++) {
        if (board[i][j] != '\u0000') {
          if (board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2]
              && board[i][j] == board[i + 3][j + 3]) {
            x = i;
            y = j;
            model = 3;
            return true;
          }
        }
      }
    }

    // �жϸ��Խ�����벿���Ƿ���������
    for (int j = 3; j <= 5; j++) {
      for (int i = 0; i < j - 2; i++) {
        if (board[i][j] != '\u0000') {
          if (board[i][j] == board[i + 1][j - 1] && board[i][j] == board[i + 2][j - 2]
              && board[i][j] == board[i + 3][j - 3]) {
            x = i;
            y = j;
            model = 4;
            return true;
          }

        }
      }
    }

    // �жϸ��Խ����Ұ벿���Ƿ���������
    for (int i = 0; i < 3; i++) {
      for (int j = 6; j >= 4 - i; j--) {
        if (board[i][j] != '\u0000') {
          if (board[i][j] == board[i + 1][j - 1] && board[i][j] == board[i + 2][j - 2]
              && board[i][j] == board[i + 3][j - 3]) {
            x = i;
            y = j;
            model = 4;
            return true;
          }

        }
      }
    }
    return false;
  }

  public void flashing() {
    if (flag == 0) {
      if (model == 1) {
        pieces[x][y].setFill(Color.WHITE);
        pieces[x][y + 1].setFill(Color.WHITE);
        pieces[x][y + 2].setFill(Color.WHITE);
        pieces[x][y + 3].setFill(Color.WHITE);

      } else if (model == 2) {
        pieces[x][y].setFill(Color.WHITE);
        pieces[x + 1][y].setFill(Color.WHITE);
        pieces[x + 2][y].setFill(Color.WHITE);
        pieces[x + 3][y].setFill(Color.WHITE);
      } else if (model == 3) {
        pieces[x][y].setFill(Color.WHITE);
        pieces[x + 1][y + 1].setFill(Color.WHITE);
        pieces[x + 2][y + 2].setFill(Color.WHITE);
        pieces[x + 3][y + 3].setFill(Color.WHITE);
      } else if (model == 4) {
        pieces[x][y].setFill(Color.WHITE);
        pieces[x + 1][y - 1].setFill(Color.WHITE);
        pieces[x + 2][y - 2].setFill(Color.WHITE);
        pieces[x + 3][y - 3].setFill(Color.WHITE);
      }
      flag = 1;
    } else {
      if (board[x][y] == 'Y') {
        if (model == 1) {
          pieces[x][y].setFill(Color.YELLOW);
          pieces[x][y + 1].setFill(Color.YELLOW);
          pieces[x][y + 2].setFill(Color.YELLOW);
          pieces[x][y + 3].setFill(Color.YELLOW);
          System.out.println(Color.YELLOW);
        } else if (model == 2) {
          pieces[x][y].setFill(Color.YELLOW);
          pieces[x + 1][y].setFill(Color.YELLOW);
          pieces[x + 2][y].setFill(Color.YELLOW);
          pieces[x + 3][y].setFill(Color.YELLOW);
          System.out.println(Color.YELLOW);
        } else if (model == 3) {
          pieces[x][y].setFill(Color.YELLOW);
          pieces[x + 1][y + 1].setFill(Color.YELLOW);
          pieces[x + 2][y + 2].setFill(Color.YELLOW);
          pieces[x + 3][y + 3].setFill(Color.YELLOW);
        } else if (model == 4) {
          pieces[x][y].setFill(Color.YELLOW);
          pieces[x + 1][y - 1].setFill(Color.YELLOW);
          pieces[x + 2][y - 2].setFill(Color.YELLOW);
          pieces[x + 3][y - 3].setFill(Color.YELLOW);
        }
      } else if (board[x][y] == 'R') {
        if (model == 1) {
          pieces[x][y].setFill(Color.RED);
          pieces[x][y + 1].setFill(Color.RED);
          pieces[x][y + 2].setFill(Color.RED);
          pieces[x][y + 3].setFill(Color.RED);
        } else if (model == 2) {
          pieces[x][y].setFill(Color.RED);
          pieces[x + 1][y].setFill(Color.RED);
          pieces[x + 2][y].setFill(Color.RED);
          pieces[x + 3][y].setFill(Color.RED);
        } else if (model == 3) {
          pieces[x][y].setFill(Color.RED);
          pieces[x + 1][y + 1].setFill(Color.RED);
          pieces[x + 2][y + 2].setFill(Color.RED);
          pieces[x + 3][y + 3].setFill(Color.RED);
        } else if (model == 4) {
          pieces[x][y].setFill(Color.RED);
          pieces[x + 1][y - 1].setFill(Color.RED);
          pieces[x + 2][y - 2].setFill(Color.RED);
          pieces[x + 3][y - 3].setFill(Color.RED);
        }
      }
      flag = 0;
    }

  }
}

public class Exercise16_31 extends Application {
  @Override
  public void start(Stage primaryStage) {
    Label displayStatus = new Label("һ��������������Ϸ��");
    BoardPane boardPane = new BoardPane();
    BorderPane pane = new BorderPane();
    pane.setCenter(boardPane);
    pane.setBottom(displayStatus);
    BorderPane.setAlignment(displayStatus, Pos.CENTER);
    Scene scene = new Scene(pane, 350, 350);
    primaryStage.setTitle("Exercise16_31"); // ��̨title
    primaryStage.setScene(scene); // ���ó�������̨��
    primaryStage.show(); // display
  }

  public static void main(String[] args) {
    launch(args);
  }
}
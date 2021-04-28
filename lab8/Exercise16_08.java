//16.8(����Բ�ཻ��)
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;

// ���񣨾��󲼾֣�
class InfoPane extends GridPane {
  private Label labX;
  private Label labY;
  private Label labR;
  private TextField tfX;
  private TextField tfY;
  private TextField tfR;

  public InfoPane() {
    this.setHgap(5);
    labX = new Label("Center x:");
    labY = new Label("Center y:");
    labR = new Label("Radius:");
    tfX = new TextField("50");
    tfY = new TextField("50");
    tfR = new TextField("50");
    // �����ı�������������Ϊ3
    tfX.setPrefColumnCount(3);
    tfY.setPrefColumnCount(3);
    tfR.setPrefColumnCount(3);
    // �ı�����뷽ʽ���Ҷ���
    tfX.setAlignment(Pos.BOTTOM_RIGHT);
    tfY.setAlignment(Pos.BOTTOM_RIGHT);
    tfR.setAlignment(Pos.BOTTOM_RIGHT);
    // ���ò���λ��
    this.add(labX, 0, 0);
    this.add(labY, 0, 1);
    this.add(labR, 0, 2);
    this.add(tfX, 1, 0);
    this.add(tfY, 1, 1);
    this.add(tfR, 1, 2);
  }

  public TextField getTfX() {
    return tfX;
  }

  public TextField getTfY() {
    return tfY;

  }

  public TextField getTfR() {
    return tfR;
  }

}

public class Exercise16_08 extends Application {
  private double paneWidth = 300;
  private double paneHeight = 300;

  private Label status = new Label("Two circles intersect? No");
  private Circle circle1 = new Circle(52, 60, 30);
  private Circle circle2 = new Circle(180, 56, 40);

  @Override
  public void start(Stage primaryStage) {

    BorderPane bigPane = new BorderPane();
    BorderPane pane = new BorderPane();
    InfoPane infopane1 = new InfoPane();
    InfoPane infopane2 = new InfoPane();
    Pane cirPane = new Pane();

    // �����ɫΪ��ɫ͸����������ɫΪ��ɫ
    circle1.setFill(new Color(1, 1, 1, 0));
    circle1.setStroke(Color.BLACK);
    circle2.setFill(new Color(1, 1, 1, 0));
    circle2.setStroke(Color.BLACK);
    cirPane.getChildren().addAll(circle1, circle2);

    HBox hBox = new HBox(20); // �����ڵ�֮���ˮƽ���Ϊ20
    hBox.setAlignment(Pos.CENTER);
    hBox.getChildren().addAll(infopane1, infopane2);
    pane.setCenter(cirPane);
    pane.setBottom(hBox);

    // ��������Բ�Ƿ��ཻ��״̬
    pane.setTop(status);
    BorderPane.setAlignment(status, Pos.CENTER);
    bigPane.setCenter(pane);

    // ���»�������Բ�İ�ť
    Button btRedraw = new Button("Redraw Circles");
    bigPane.setBottom(btRedraw);

    BorderPane.setAlignment(btRedraw, Pos.CENTER); // ���ð�ť���ж���

    btRedraw.setOnAction(e -> {
      double newX1 = Double.parseDouble(infopane1.getTfX().getText());
      double newY1 = Double.parseDouble(infopane1.getTfY().getText());
      double newR1 = Double.parseDouble(infopane1.getTfR().getText());
      double newX2 = Double.parseDouble(infopane2.getTfX().getText());
      double newY2 = Double.parseDouble(infopane2.getTfY().getText());
      double newR2 = Double.parseDouble(infopane2.getTfR().getText());
      circle1.setCenterX(newX1);
      circle1.setCenterY(newY1);
      circle1.setRadius(newR1);
      circle2.setCenterX(newX2);
      circle2.setCenterY(newY2);
      circle2.setRadius(newR2);

      checkStatus();
    });
    /*
     * �϶�����ƶ���Ϣ getX() getY() ��ȡ��ǰ�϶�λ�õ�x��y����
     */
    circle1.setOnMouseDragged(e -> {
      circle1.setCenterX(e.getX());
      circle1.setCenterY(e.getY());
      // setText������Ҫ��String����
      infopane1.getTfX().setText(e.getX() + "");
      infopane1.getTfY().setText(e.getY() + "");
      checkStatus();
    });

    circle2.setOnMouseDragged(e -> {

      circle2.setCenterX(e.getX());
      circle2.setCenterY(e.getY());
      infopane2.getTfX().setText(e.getX() + "");
      infopane2.getTfY().setText(e.getY() + "");
    });

    Scene scene = new Scene(bigPane, paneWidth, paneHeight);
    primaryStage.setTitle("Exercise16_08"); // ��̨title
    primaryStage.setScene(scene); // ���ó�������̨��
    primaryStage.show(); // display
  }

  private void checkStatus() {
    double x1 = circle1.getCenterX();
    double y1 = circle1.getCenterY();
    double r1 = circle1.getRadius();
    double x2 = circle2.getCenterX();
    double y2 = circle2.getCenterY();
    double r2 = circle2.getRadius();
    double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    if (d <= r1 + r2) {
      status.setText("Two circles intersect? Yes");
    } else {
      status.setText("Two circles intersect? No");
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
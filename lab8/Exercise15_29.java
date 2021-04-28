//15.29��������
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

//Duration��������¼�
public class Exercise15_29 extends Application {
  @Override
  public void start(Stage primaryStage) {

    CarPane car = new CarPane();
    Scene scene = new Scene(car, 600, 400);// ��������
    // ʱ���߼�ʱ�� ��������ˢ��ʱ��Ϊ50

    // ������괥���¼�
    car.setOnMousePressed(e -> car.pause());
    car.setOnMouseReleased(e -> car.play());

    // ���۽��Ľ����Խ���KeyEvent�¼�
    car.requestFocus();// car���Խ��ռ�������
    // ����ϼ����٣��Ҽ��¼����� �س���ͣ
    car.setOnKeyPressed(e -> {
      switch (e.getCode()) {
      case UP:
        car.increaseSpeed();
        break;
      case RIGHT:
        car.increaseSpeed();
        break;
      case DOWN:
        car.decreaseSpeed();
        break;
      case LEFT:
        car.decreaseSpeed();
        break;
      case ENTER:
        car.pause();
        break;
      }
    });

    primaryStage.setTitle("Exercise15_29"); // ��̨title
    primaryStage.setScene(scene); // ���ó�������̨��
    primaryStage.show(); // display
  }

  public static void main(String[] args) {
    launch(args);
  }
}

// �������
class CarPane extends Pane {
  private double w = 600;
  private double h = 400;
  private double baseX = 0;
  private double baseY = h;

  private double r = 5;// �������Ӱ뾶
  private Timeline animation;

  // ������������
  Circle wheel1 = new Circle(baseX + 10 + 5, baseY - 10 + 5, r);
  Circle wheel2 = new Circle(baseX + 30 + 5, baseY - 10 + 5, r);
  // ���Ƴ���
  Rectangle carBody = new Rectangle(baseX, baseY - 20, 50, 10);
  // ���Ƴ�����
  Polygon carTop = new Polygon(baseX + 10, baseY - 20, baseX + 20, baseY - 30, baseX + 30, baseY - 30, baseX + 40,
      baseY - 20);

  // ���캯��
  public CarPane() {
    wheel1.setFill(Color.BLACK);
    wheel2.setFill(Color.BLACK);
    carBody.setFill(Color.BLUE);
    carTop.setFill(Color.RED);
    this.getChildren().addAll(wheel1, wheel2, carBody, carTop);
    animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveCar()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // ��ʼ����
  }

  // �����ƶ�����
  public void moveCar() {
    if (baseX > w) {
      baseX = -20;
      //�����
    } else {
      baseX += 1;
    }
    setValues();
  }

  // �˶�
  public void play() {
    animation.play();
  }

  // ��ͣ
  public void pause() {
    animation.pause();
  }

  // ����
  public void increaseSpeed() {
    animation.setRate(animation.getRate() + 1);
  }

  // ����
  public void decreaseSpeed() {
    animation.setRate(animation.getRate() - 1);
  }

  public void setValues() {
    wheel1.setCenterX(baseX + 10 + 5);
    wheel1.setCenterY(baseY - 10 + 5);
    wheel2.setCenterX(baseX + 30 + 5);
    wheel2.setCenterY(baseY - 10 + 5);

    carBody.setX(baseX);
    carBody.setY(baseY - 20);

    carTop.getPoints().clear();
    carTop.getPoints().addAll(baseX + 10, baseY - 20, baseX + 20, baseY - 30, baseX + 30, baseY - 30, baseX + 40,
        baseY - 20);
  }

}
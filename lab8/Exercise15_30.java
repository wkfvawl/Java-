//15.30(���Żõ�Ƭ)
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.util.Duration;

//Duration��������¼�
public class Exercise15_30 extends Application {

  @Override
  public void start(Stage primaryStage) {

    // �õ�Ƭ����
    SlidePane slidepane = new SlidePane();
    // ����¼�
    // ���������ѹ-�ͷţ�
    slidepane.setOnMouseClicked(e -> {
      // ��鶯����ǰ��״̬
      if (slidepane.getAnimationStatus() == 1) {
        slidepane.pause();
      } else if (slidepane.getAnimationStatus() == 3) {
        {
          slidepane.play();
        }
      }
    });

    // �õ�Ƭͼ���СΪ800*600���أ�������ƥ��ĳ���
    Scene scene = new Scene(slidepane, 800, 600);
    primaryStage.setTitle("Exercise15_30"); // ��̨title
    primaryStage.setScene(scene); // ���ó�������̨��
    primaryStage.show(); // display

  }

  public static void main(String[] args) {
    launch(args);
  }
}

// �õ�Ƭ������
class SlidePane extends StackPane {

  private Image[] image = new Image[25];
  private ImageView imageView;// ��ʾһ��ͼ��
  private Timeline animation;
  private int cnt = 0;// ��¼��ʾͼ���ҳ��

  // ���캯��
  public SlidePane() {
    for (int i = 0; i < 25; i++) {
      image[i] = new Image("file:image/slide" + i + ".jpg");
    }
    // ����ͼ���ļ�ǰ��ӡ�http://�����������ļ���Ҫ�ӡ�file:��
    imageView = new ImageView(image[0]);// ָ���һ����Ҫ��ʾ��ͼ��
    this.getChildren().add(imageView);
    animation = new Timeline(new KeyFrame(Duration.millis(2000), e -> run()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
  }

  // ����״̬���Զ�ѭ��������һ�Żõ�Ƭ
  public void run() {

    int index = cnt % 25;
    cnt++;
    imageView.setImage(image[index]);
  }

  // ����
  public void play() {
    animation.play();
  }

  // ��ͣ
  public void pause() {
    animation.pause();
  }

  /*
   * ��ȡ������ǰ״̬ ���ŷ���1 ��ֹ����2 ��ͣ����3
   */
  public int getAnimationStatus() {
    if (animation.getStatus() == Animation.Status.RUNNING) {
      return 1;
    } else if (animation.getStatus() == Animation.Status.STOPPED) {
      return 2;
    } else if (animation.getStatus() == Animation.Status.PAUSED) {
      return 3;
    }
    return 0;
  }

}
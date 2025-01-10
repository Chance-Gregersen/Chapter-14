import java.util.Calendar;
  import java.util.GregorianCalendar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
  import javafx.scene.shape.Circle;
  import javafx.scene.shape.Line;
  import javafx.scene.text.Text;
  import javafx.stage.Stage;

  public class App extends Application {
    public static void main(String[] args) {
      launch(args);
  }
    private int hour = (int)(Math.random() * 6);
    private int minute = (int)(Math.random() * 5);
    private int second = (int)(Math.random() * 10);

@Override
    public void start(Stage primaryStage) {
    double clockRadius = 200;
    double centerX = 400 /2;
    double centerY = 400 /2;
    Pane pane = new Pane();


    
    // Draw circle
    Circle circle = new Circle(centerX, centerY, clockRadius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
    Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
    Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
    Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

    // Draw second hand
    
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 2));
    double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 2));
    Line sLine = new Line(centerX, centerY, secondX, secondY);
    sLine.setStroke(Color.WHITE); //make second hand invisible

    // Draw minute hand
    double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength *Math.sin(minute * (2 * Math.PI / 60));
    double minuteY = centerY - mLength *Math.cos(minute * (2 * Math.PI / 60));
    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    mLine.setStroke(Color.BLUE);

    // Draw hour hand
    double hLength = clockRadius *  0.5;
    double hourX = centerX + hLength *Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.GREEN);

    pane.getChildren().clear();
    pane.getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
    primaryStage.setScene(new Scene(pane, 600, 600));
    primaryStage.show();
    }
  }

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15_03  extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		HBox buttons = new HBox();
		buttons.setSpacing(10);
		buttons.setAlignment(Pos.CENTER);

		//buttons
		Button up = new Button("Up");
		Button down = new Button("Down");
		Button left = new Button("Left");
		Button right = new Button("Right");
		buttons.getChildren().addAll(up, down, left, right);

		//the circle
		Circle ball = new Circle(125, 100, 30);
		ball.setFill(Color.WHITE);
		ball.setStroke(Color.BLACK);
		pane.getChildren().add(ball);

		//adding the HBox and the Pane together
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(buttons);

		//adding the transitions
		int[] position = new int[2];
		position[0] = 0;
		position[1] = 0;
		if (position[1] > -10) {
			position[1] -= 10;
			up.setOnMouseClicked(e -> ball.setTranslateY(ball.getTranslateY() - 10));
		}
		if (position[1] < 135) {
			position[1] += 10;
			down.setOnMouseClicked(e -> ball.setTranslateY(ball.getTranslateY() + 10));
		}
		if (position[0] > -135) {
			position[0] -=10;
			left.setOnMouseClicked(e -> ball.setTranslateX(ball.getTranslateX() - 10));
		}
		if (position[0] < 135) {
			position[0] +=10;
			right.setOnMouseClicked(e -> ball.setTranslateX(ball.getTranslateX() + 10));
		}

		//showing code
		Scene scene = new Scene(borderPane, 300, 300);
		primaryStage.setTitle("PathTransitionDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

}

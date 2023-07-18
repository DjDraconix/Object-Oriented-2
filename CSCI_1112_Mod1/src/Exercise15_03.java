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
	Pane pane;
	@Override
	public void start(Stage primaryStage) throws Exception {
		pane = new Pane();
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
		Circle ball = new Circle(150, 150, 30);
		ball.setFill(Color.WHITE);
		ball.setStroke(Color.BLACK);
		pane.getChildren().add(ball);

		//adding the HBox and the Pane together
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(buttons);

		//showing code
		Scene scene = new Scene(borderPane, 300, 300);
		primaryStage.setTitle("PathTransitionDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//adding the transitions
		up.setOnMouseClicked(e -> moveBallInDirection(ball, 0, -10));
		down.setOnMouseClicked(e -> moveBallInDirection(ball, 0, 10));
		left.setOnMouseClicked(e -> moveBallInDirection(ball, -10, 0));
		right.setOnMouseClicked(e -> moveBallInDirection(ball, 10, 0));

	}
	void moveBallInDirection(Circle ball, int directionX, int directionY) {
		if (ball.getTranslateX() + directionX < pane.getWidth() / 2.0 && ball.getTranslateX() + directionX > -(pane.getWidth() / 2.0)) {
			ball.setTranslateX(ball.getTranslateX() + directionX); 
		}
		if (ball.getTranslateY() + directionY < pane.getHeight() / 2.0 && ball.getTranslateY() + directionY > -(pane.getHeight() / 2.0)) {
		ball.setTranslateY(ball.getTranslateY() + directionY);
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}

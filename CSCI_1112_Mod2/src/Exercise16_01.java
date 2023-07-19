import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercise16_01 extends Application{
	Pane pane;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Pane
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 150);
		
		// The Text
		Label text = new Label("Programing is fun");
		text.setTranslateX(pane.getWidth() / 2.0 - 40);
		text.setTranslateY(pane.getHeight() / 2.0 - 20);
		
		pane.getChildren().add(text);
		
		// Buttons
		Button left = new Button("<=");
		left.setTranslateY(pane.getHeight() - 30);
		left.setTranslateX((pane.getWidth() / 2) - 40);
		Button right = new Button("=>");
		right.setTranslateY(pane.getHeight() - 30);
		right.setTranslateX((pane.getWidth() / 2) + 20);
		
		pane.getChildren().addAll(right, left);
		
		// Toggle Buttons
		RadioButton red = new RadioButton("Red");
		red.setTranslateX(0);
		RadioButton yellow = new RadioButton("Yellow");
		yellow.setTranslateX((pane.getWidth() / 5) * 1);
		RadioButton black = new RadioButton("Black");
		black.setTranslateX((pane.getWidth() / 5) * 2);
		black.setSelected(true);
		RadioButton orange = new RadioButton("Orange");
		orange.setTranslateX((pane.getWidth() / 5) * 3);
		RadioButton green = new RadioButton("Green");
		green.setTranslateX((pane.getWidth() / 5) * 4);
		
		// Toggle Group
		ToggleGroup color = new ToggleGroup();
		red.setToggleGroup(color);
		yellow.setToggleGroup(color);
		black.setToggleGroup(color);
		orange.setToggleGroup(color);
		green.setToggleGroup(color);
		
		pane.getChildren().addAll(red, yellow, black, orange, green);
		
		// Printing the scene
		primaryStage.setTitle("Exercise16_01");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// What the button do
		red.setOnAction(e -> {
			if (red.isSelected()) {
				text.setTextFill(Color.RED);
			}
		});
		yellow.setOnAction(e -> {
			if (yellow.isSelected()) {
				text.setTextFill(Color.YELLOW);
			}
		});
		black.setOnAction(e -> {
			if (black.isSelected()) {
				text.setTextFill(Color.BLACK);
			}
		});
		orange.setOnAction(e -> {
			if (orange.isSelected()) {
				text.setTextFill(Color.ORANGE);
			}
		});
		green.setOnAction(e -> {
			if (green.isSelected()) {
				text.setTextFill(Color.GREEN);
			}
		});
		left.setOnMouseClicked(e -> {
			if (text.getTranslateX() - 10 > 0) {
			 text.setTranslateX(text.getTranslateX() - 10); 
			}
		});
		right.setOnMouseClicked(e -> {
			if (text.getTranslateX() + 10 < pane.getWidth() - 90) {
				 text.setTranslateX(text.getTranslateX() + 10); 
				}
		});
		
	}


	public static void main(String[] args) {
		launch(args);
	}
}

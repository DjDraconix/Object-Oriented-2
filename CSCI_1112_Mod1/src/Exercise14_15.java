import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;

public class Exercise14_15 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		// Create a scene and place it in the stage
		Pane plane = new StackPane();
		plane.getChildren().add(new MyPolygon());
		Label label = new Label("STOP");
		label.setTextFill(Color.WHITE);
		label.setFont(Font.font("Times New Roman", 80));
		plane.getChildren().add(label);
		Scene scene = new Scene(plane, 400, 400);
		//Scene scene = new Scene(new MyPolygon(), 400, 400);
		primaryStage.setTitle("StopSign"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

class MyPolygon extends Pane {
	private void paint() {
		// Create a polygon and place polygon to pane
		Polygon polygon = new Polygon();
		polygon.setFill(Color.RED);
		polygon.setStroke(Color.RED);
		ObservableList<Double> list = polygon.getPoints();
		
		double centerX = getWidth() / 2, centerY = getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;

		// s represents the number of sides of the shape
		// Make sure to update this number when necessary
		int s = 8;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.sin(2 * i * Math.PI / s - 20.03)); 
			list.add(centerY - radius * Math.cos(2 * i * Math.PI / s - 20.03));
		}     
		
		getChildren().clear();
		getChildren().add(polygon);
		
		
		
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}
	
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_Animation extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Pane
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 400);
		
		// Pentagon
		Polygon pentagon = new Polygon();
		pentagon.setFill(Color.WHITE);
		pentagon.setOpacity(1);
		pentagon.setStroke(Color.BLACK);
		ObservableList<Double> list = pentagon.getPoints();
		double centerX = pane.getWidth() / 2, centerY = pane.getHeight() / 2;
		double radius = Math.min(pane.getWidth(), pane.getHeight()) * 0.4;
		int s = 6;
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.sin(2 * i * Math.PI / s)); 
			list.add(centerY - radius * Math.cos(2 * i * Math.PI / s));
		}
		pane.getChildren().add(pentagon);
		
		// Rectangle
		Rectangle rectangle = new Rectangle(0, 0, 25, 50);
		rectangle.setFill(Color.RED);
		rectangle.setStroke(Color.BLACK);
		pane.getChildren().add(rectangle);
		
		// The scene
		primaryStage.setTitle("Animation");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// Path Transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(pentagon);
		pt.setNode(rectangle);
		pt.setOrientation(
				PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(false);
		pt.play();
		
		
		// Fade Transition
		FadeTransition ft = new FadeTransition(Duration.millis(4000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		
		pane.setOnMousePressed(e -> {
			if(e.isSecondaryButtonDown()) {
			pt.pause();
			ft.pause();
			}
			if(e.isPrimaryButtonDown()) {
			pt.play();
			ft.play();
			}
		});
	}
	
	public static void toggel(Pane pane, PathTransition pt) {
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

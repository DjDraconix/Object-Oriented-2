import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_21 extends Application{

	private static String URL = 
			"https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Pane and scene
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 350, 200);

		// Button
		Button go = new Button("Go");
		go.setTranslateX(pane.getWidth() - 50);

		pane.getChildren().add(go);

		// Text Field
		TextField userIn = new TextField("Enter a whole number");
		userIn.setEditable(true);
		userIn.setStyle("-fx-text-fill: black");
		userIn.setFont(Font.font("Times", 20));
		userIn.setAlignment(Pos.BASELINE_RIGHT);

		pane.getChildren().add(userIn);

		// Label
		Label label = new Label();
		label.setTranslateX(145);
		label.setTranslateY(90);
		label.setFont(Font.font(30));

		pane.getChildren().add(label);

		// Media
		Media media = new Media(URL);
		MediaPlayer alarm = new MediaPlayer(media);

		// Printing the scene
		primaryStage.setTitle("Exercise16_21");
		primaryStage.setScene(scene);
		primaryStage.show();

		go.setOnMouseClicked(e -> countdown(userIn, label, alarm));
	}

	public void countdown(TextField userIn, Label label, MediaPlayer alarm) {
		// Event Handeler to change number
		label.setText(userIn.getText());
		EventHandler<ActionEvent> eventHandler = e -> {
			if (label.getText().equals(userIn.getText())) {
				String fromUser = userIn.getText();
				int numb = Integer.parseInt(fromUser);
				String text = Integer.toString(numb - 1);
				label.setText(text);
			} else if (!label.getText().equals("0")) {
				String fromUser = label.getText();
				System.out.println(fromUser);
				int numb = Integer.parseInt(fromUser);
				String text = Integer.toString(numb - 1);
				label.setText(text);
			}
			if (label.getText().equals("0")) {
				alarm.play();
			}
		};

		// Timeline
		Timeline animation = new Timeline(
				new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

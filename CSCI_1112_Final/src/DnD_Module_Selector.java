import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DnD_Module_Selector extends Application{
	Module Printed;
	private static Module[] makeModules() throws FileNotFoundException {
		
		//https://www.thegamer.com/dungeons-dragons-5e-modules-best-ranked/#descent-into-avernus
		Module[] Modules = new Module[20];

		Modules[0] = (new Module("Curse of Strahd", 5, 4));

		Modules[1] = (new Module("Tales from the Yawning Portal", 1, 4));

		Modules[2] = (new Module("Keys from the Golden Valut", 4, 2));

		Modules[3] = (new Module("Tomb of Annihilation", 5, 2));

		Modules[4] = (new Module("Lost Mines of Phandelver", 2, 1));

		Modules[5] = (new Module("Out of the Abyss", 5, 1));

		Modules[6] = (new Module("Descent Into Avernus", 4, 3));

		Modules[7] = (new Module("Ghosts of Saltmarsh", 3, 1));

		Modules[8] = (new Module("The Wild Beyond the Witchlight", 3, 4));

		Modules[9] = (new Module("Rime of the Frostmaiden", 4 ,4));

		Modules[10] = (new Module("Dragon of Icepire Peak", 1, 2));

		Modules[11] = (new Module("Shadow of the Dragon Queen", 5, 3));

		Modules[12] = (new Module("Dungeon of the Mad Mage", 2, 2));

		Modules[13] = (new Module("Princes of the Apocalypse", 2, 3));

		Modules[14] = (new Module("Dragon Heist", 2, 4));

		Modules[15] = (new Module("Storm King's Thunder", 3, 2));

		Modules[16] = (new Module("Call of the Netherdeep", 3, 3));

		Modules[17] = (new Module("Candelkeep Mysteries", 1, 3));

		Modules[18] = (new Module("Dragons of Stormwreck Isle", 1, 1));

		Modules[19] = (new Module("A Curriculum of Chaos", 4, 1));

		return Modules;
	}

	public void start(Stage primaryStage) throws Exception {
		Printed = new Module("blank", 0, 0);

		// Pane
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 400);

		// The Image
		Image cover = Printed.getImage();
		ImageView fullCover = new ImageView(cover);
		fullCover.setFitHeight(240);
		fullCover.setFitWidth(175);
		fullCover.setTranslateX(10);
		fullCover.setTranslateY(70);
		pane.getChildren().add(fullCover);

		//The text File
		RandomAccessFile file = Printed.getExplination();
		String toLabel = "";
		toLabel = toLabel + file.readLine() + "\n";
		toLabel = toLabel + file.readLine();
		Text text = new Text(toLabel);
		text.setWrappingWidth(200);
		text.setTranslateX(195);
		text.setTranslateY(45);
		pane.getChildren().add(text);

		//Level combo box
		ComboBox<String> level = new ComboBox<>();
		level.getItems().addAll("1. Compleatly New", "2. Basic Skill Level",
				"3. Good Grasp of Game", "4. Seasoned Players");
		level.setValue("Player Level");
		level.setTranslateX(5);
		level.setTranslateY(5);
		pane.getChildren().add(level);

		//length combo box
		ComboBox<String> length = new ComboBox<>();
		length.getItems().addAll("1-3 Sessions", "4-8 Sessions",
				"9-15 Sessions", "16-24 Sessions", "24-32+ Sessions");
		length.setValue("Campaign Length");
		length.setTranslateX(level.getWidth() + 190);
		length.setTranslateY(5);
		pane.getChildren().add(length);

		// Button to confirm changes
		Button go = new Button("Go");
		go.setTranslateX(350);
		go.setTranslateY(5);
		pane.getChildren().add(go);

		// Printing the scene
		primaryStage.setTitle("Module Selector");
		primaryStage.setScene(scene);
		primaryStage.show();

		go.setOnMouseClicked(e -> {
			try {
				Printed = Checkboxes(level, length);
				
		        Image newCover = Printed.getImage();
		        fullCover.setImage(newCover);

		        String newToLabel = "";
		        newToLabel = newToLabel + Printed.getExplination().readLine() + "\n";
		        newToLabel = newToLabel + Printed.getExplination().readLine();
		        text.setText(newToLabel);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

	private static Module Checkboxes(ComboBox<String> level, ComboBox<String> length) throws FileNotFoundException {
		Module[] Modules = makeModules();
		Module UserChoice = new Module();
		
		int PlayerLevel = 0;
		int PlayTime = 0;
		if(level.getValue().contains("1")) {
			PlayerLevel = 1;
		}
		if(level.getValue().contains("2")) {
			PlayerLevel = 2;
		}
		if(level.getValue().contains("3")) {
			PlayerLevel = 3;
		}
		if(level.getValue().contains("4")) {
			PlayerLevel = 4;
		}
		if(length.getValue().contains("1-")) {
			PlayTime = 1;
		}
		if(length.getValue().contains("4-")) {
			PlayTime = 2;
		}
		if(length.getValue().contains("9-")) {
			PlayTime = 3;
		}
		if(length.getValue().contains("16-")) {
			PlayTime = 4;
		}
		if(length.getValue().contains("24-")) {
			PlayTime = 5;
		}

		for (int i = 0; i < Modules.length; i++) {
			if(Modules[i].getLevel() == PlayerLevel && Modules[i].getLength() == PlayTime) {
				UserChoice = Modules[i];
			}
		}
		return UserChoice;
	}
}

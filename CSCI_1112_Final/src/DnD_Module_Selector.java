import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DnD_Module_Selector extends Application{

	public void start(Stage primaryStage) throws Exception {
		Module toUser = new Module("blank", 0, 0);
		int playerLevel = 0;
		int playTime = 0;
		
		// Pane
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 300);
		
		// The Image
		Image cover = toUser.getImage();
		ImageView fullCover = new ImageView(cover);
		fullCover.setFitHeight(240);
		fullCover.setFitWidth(175);
		fullCover.setTranslateX(10);
		fullCover.setTranslateY(40);
		pane.getChildren().add(fullCover);
		
		//The text File
		/*
		Scanner file = new Scanner(toUser.getExplination());
		String toLabel = "";
		while (file.hasNext()) {
			toLabel += file.nextLine();
		}
		Label Text = new Label(toLabel);
		Text.setMaxSize(175, 240);
		Text.setTranslateX(195);
		Text.setTranslateY(40);
		pane.getChildren().add(Text);
		*/

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
		
		go.setOnMouseClicked(e -> Checkboxes(level, length, playerLevel, playTime, toUser));
	}

	public static void main(String[] args) {
		launch(args);
	}

	private static void Checkboxes(ComboBox<String> level, ComboBox<String> length, int PlayerLevel, int PlayTime, Module toPlayer) {
		ArrayList<Module> modules = makeModules();
		System.out.println(toPlayer.getName());
		if(level.getValue().contains("1")) {
			PlayerLevel = 1;
			System.out.println("Yes");
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
			System.out.println("No");
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
		for (int i = 0; i < modules.size() - 1; i++) {
			System.out.println(modules.get(i).getLevel());
			if(modules.get(i).getLevel() == PlayerLevel && modules.get(i).getLength() == PlayTime) {
				toPlayer = modules.get(i);
				System.out.println(PlayerLevel);
				System.out.println(PlayTime);
			}
		}
	}
	
	private static ArrayList<Module> makeModules() {
		//Website used
		//https://www.thegamer.com/dungeons-dragons-5e-modules-best-ranked/#descent-into-avernus
		ArrayList<Module> Modules = new ArrayList<Module>();
		Module mod = new Module("Curse of Strahd", 5, 4);
		Modules.add(mod);
		mod = new Module("Tales from the Yawning Portal", 1, 4);
		Modules.add(mod);
		mod = new Module("Keys from the Golden Valut", 4, 2);
		Modules.add(mod);
		mod = new Module("Tomb of Annihilation", 5, 2);
		Modules.add(mod);
		mod = new Module("Lost Mines of Phandelver", 2, 1);
		Modules.add(mod);
		mod = new Module("Out of the Abyss", 5, 1);
		Modules.add(mod);
		mod = new Module("Descent Into Avernus", 4, 3);
		Modules.add(mod);
		mod = new Module("Ghosts of Saltmarsh", 3, 1);
		Modules.add(mod);
		mod = new Module("The Wild Beyond the Witchlight", 3, 4);
		Modules.add(mod);
		mod = new Module("Rime of the Frostmaiden", 4 ,4);
		Modules.add(mod);
		mod = new Module("Dragon of Icepire Peak", 1, 2);
		Modules.add(mod);
		mod = new Module("Shadow of the Dragon Queen", 5, 3);
		Modules.add(mod);
		mod = new Module("Dungeon of the Mad Mage", 2, 2);
		Modules.add(mod);
		mod = new Module("Princes of the Apocalypse", 2, 3);
		Modules.add(mod);
		mod = new Module("Dragon Heist", 2, 4);
		Modules.add(mod);
		mod = new Module("Storm King's Thunder", 3, 2);
		Modules.add(mod);
		mod = new Module("Call of the Netherdeep", 3, 3);
		Modules.add(mod);
		mod = new Module("Candelkeep Mysteries", 1, 3);
		Modules.add(mod);
		mod = new Module("Dragons of Stormwreck Isle", 1, 1);
		Modules.add(mod);
		mod = new Module("A Curriculum of Chaos", 4, 1);
		Modules.add(mod);
		
		return Modules;
	}
}

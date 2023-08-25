import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DnD_Module_Selector extends Application{

	public void start(Stage primaryStage) throws Exception {
		ArrayList<Module> modules = makeModules();
		
		int playerLevel = 0;
		int playTime = 0;
		
		// Pane
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 300);

		//Level combo box
		ComboBox<String> level = new ComboBox<>();
		level.getItems().addAll("Compleatly New", "Newer Player",
				"Well Played", "Above Average", "Seasoned Players");
		level.setValue("Player Level");
		level.setTranslateX(5);
		level.setTranslateY(5);
		pane.getChildren().add(level);

		//length combo box
		ComboBox<String> length = new ComboBox<>();
		length.getItems().addAll("1-3 Sessions", "4-8 Sessions",
				"9-15 Sessions", "16-24 Sessions", "24-32+ Sessions");
		length.setValue("Campaign Length");
		length.setTranslateX(pane.getWidth() - 150);
		length.setTranslateY(5);
		pane.getChildren().add(length);

		// Printing the scene
		primaryStage.setTitle("Module Selector");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private static ArrayList<Module> makeModules() {
		//Website used
		//https://www.thegamer.com/dungeons-dragons-5e-modules-best-ranked/#descent-into-avernus
		ArrayList<Module> Modules = new ArrayList<Module>();
		Module mod = new Module("Curse of Strahd", 5, 5);
		Modules.add(mod);
		mod = new Module("Tales from the Yawning Portal", 1, 3);
		Modules.add(mod);
		mod = new Module("Keys from the Golden Valut", 3, 2);
		Modules.add(mod);
		mod = new Module("Tomb of Annihilation", 4, 4);
		Modules.add(mod);
		mod = new Module("Lost Mines of Phandelver", 1, 1);
		Modules.add(mod);
		mod = new Module("Out of the Abyss", 4, 3);
		Modules.add(mod);
		mod = new Module("Descent Into Avernus", 3, 3);
		Modules.add(mod);
		mod = new Module("Ghosts of Saltmarsh", 3, 2);
		Modules.add(mod);
		mod = new Module("The Wild Beyond the Witchlight", 3, 2);
		Modules.add(mod);
		mod = new Module("Rime of the Frostmaiden", 4 ,4);
		Modules.add(mod);
		mod = new Module("Dragon of Icepire Peak", 1, 1);
		Modules.add(mod);
		mod = new Module("Shadow of the Dragon Queen", 4, 3);
		Modules.add(mod);
		mod = new Module("Dungeon of the Mad Mage", 2, 2);
		Modules.add(mod);
		mod = new Module("Princes of the Apocalypse", 2, 2);
		Modules.add(mod);
		mod = new Module("Dragon Heist", 2, 2);
		Modules.add(mod);
		mod = new Module("Storm King's Thunder", 3, 2);
		Modules.add(mod);
		mod = new Module("Call of the Netherdeep", 3, 3);
		Modules.add(mod);
		mod = new Module("Candelkeep Mysteries", 1, 3);
		Modules.add(mod);
		mod = new Module("Dragons of Stormwreck Isle", 1, 1);
		Modules.add(mod);
		mod = new Module("A Curriculum of Chaos", 3, 3);
		Modules.add(mod);
		
		return Modules;
	}
}

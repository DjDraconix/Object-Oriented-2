import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

public class DnD_Module_Selector extends Application{

	public void start(Stage primaryStage) throws Exception {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings("unused")
	private static ArrayList<Module> makeModules() {
		//Website used
		//https://www.thegamer.com/dungeons-dragons-5e-modules-best-ranked/#descent-into-avernus
		ArrayList<Module> Modules = new ArrayList<Module>();
		Module mod = new Module("Curse of Strahd");
		Modules.add(mod);
		mod = new Module("Tales from the Yawning Portal");
		Modules.add(mod);
		mod = new Module("Keys from the Golden Valut");
		Modules.add(mod);
		mod = new Module("Tomb of annihilation");
		Modules.add(mod);
		mod = new Module("Lost Mines of Phandelver");
		Modules.add(mod);
		mod = new Module("Out of the Abyss");
		Modules.add(mod);
		mod = new Module("Descent Into Avernus");
		Modules.add(mod);
		mod = new Module("Ghosts of Saltmarsh");
		Modules.add(mod);
		mod = new Module("The Wild Beyond the Witchlight");
		Modules.add(mod);
		mod = new Module("Rime of the Frostmaiden");
		Modules.add(mod);
		mod = new Module("Dragon of Icepire Peak");
		Modules.add(mod);
		mod = new Module("Shadow of the Dragon Queen");
		Modules.add(mod);
		mod = new Module("Dungeon of the Mad Mage");
		Modules.add(mod);
		mod = new Module("Princes of the Apocalypse");
		Modules.add(mod);
		mod = new Module("Dragon Heist");
		Modules.add(mod);
		mod = new Module("Storm King's Thunder");
		Modules.add(mod);
		mod = new Module("Call of the Netherdeep");
		Modules.add(mod);
		mod = new Module("Candelkeep Mysteries");
		Modules.add(mod);
		mod = new Module("Dragons of Stormwreck Isle");
		Modules.add(mod);
		mod = new Module("A Curriculum of Chaos");
		Modules.add(mod);
		return Modules;
	}
}

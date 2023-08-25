import java.io.File;

import javafx.scene.image.Image;

public class Module {
	static String Name;
	static File Explanation;
	static Image Cover;
	static int Length;
	//1- one or two sessions
	//3- a few months of sessions
	//5- a years worth of sessions
	static int Level;
	//1- new players
	//3- players no how to play decently
	//5- players are seasoned and know most of the rules
	
	public Module(String book, int time, int experiance){
		Name = book;
		Cover = new Image(book + ".gif");
		Explanation = new File(book + ".txt");
		Length = time;
		Level = experiance;
	}

	@SuppressWarnings("unused")
	private static File getExplination() {
		return Explanation;
	}
	
	@SuppressWarnings("unused")
	private static Image getImage() {
		return Cover;
	}
	
	@SuppressWarnings("unused")
	private static String getName() {
		return Name;
	}
	
	@SuppressWarnings("unused")
	private static int getLength() {
		return Length;
	}
	
	@SuppressWarnings("unused")
	private static int getLevel() {
		return Level;
	}
	
}

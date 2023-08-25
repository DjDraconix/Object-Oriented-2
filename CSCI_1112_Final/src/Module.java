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

	File getExplination() {
		return Explanation;
	}
	
	Image getImage() {
		return Cover;
	}
	
	String getName() {
		return Name;
	}
	
	int getLength() {
		return Length;
	}
	
	int getLevel() {
		return Level;
	}
	
}

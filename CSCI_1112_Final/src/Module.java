import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import javafx.scene.image.Image;

public class Module {
	static String Name;
	static RandomAccessFile Explanation;
	static Image Cover;
	static int Length;
	//1- one or two sessions
	//3- a few months of sessions
	//5- a years worth of sessions
	static int Level;
	//1- new players
	//2- base level knowledge
	//3- players no how to play decently
	//4- players are seasoned and know most of the rules
	
	public Module(String book, int time, int experiance) throws FileNotFoundException{
		Name = book;
		Cover = new Image("file:///Users/student/Desktop/Object-Oriented-2/CSCI_1112_Final/D&D%20Images/" + book + ".gif");
		Explanation = new RandomAccessFile(book + ".txt", "rw");
		Length = time;
		Level = experiance;
	}

	RandomAccessFile getExplination() {
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

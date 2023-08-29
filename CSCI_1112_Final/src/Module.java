import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import javafx.scene.image.Image;

public class Module {
	String Name;
	RandomAccessFile Explanation;
	Image Cover;
	int Length;
	//1- one or two sessions
	//3- a few months of sessions
	//5- a years worth of sessions
	int Level;
	//1- new players
	//2- base level knowledge
	//3- players no how to play decently
	//4- players are seasoned and know most of the rules
	
	public Module() {
		Name = "Null book";
	}
	
	public Module(String book, int time, int experiance) throws FileNotFoundException{
		Name = book;
		File f = new File("D&D Images/" + book + ".gif");
		FileInputStream stream = new FileInputStream(f);
		Cover = new Image(stream);
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

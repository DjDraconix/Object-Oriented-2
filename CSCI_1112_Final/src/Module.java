import java.io.File;

import javafx.scene.image.Image;

public class Module {
	static String Name;
	static File Explanation;
	static Image Cover;
	
	Module(String book){
		Name = book;
		Cover = new Image(book + ".gif");
		Explanation = new File(book + ".txt");
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
	
}

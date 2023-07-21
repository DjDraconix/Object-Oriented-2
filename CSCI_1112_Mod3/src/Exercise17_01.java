import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Exercise17_01 {

	public static void main(String[] args) throws FileNotFoundException {
		File text = new File("Exercise17_01.txt");

		if (text.exists()) {
			PrintWriter fileOut = new PrintWriter(text);

			int[] numbers = new int[100];
			for (int i = 0; i < 100; i++) {
				numbers[i] = (int) (Math.random() * 100);
			}

			for (int i = 0; i < 100; i++) {
				fileOut.print(numbers[i] + " ");
			}

			fileOut.close();
		}
	}

}

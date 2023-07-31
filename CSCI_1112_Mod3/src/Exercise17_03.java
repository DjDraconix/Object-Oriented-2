import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise17_03 {

	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("Exercise17_03.dat");
		
		if(!data.exists()) {
			PrintWriter fileOut = new PrintWriter(data);
			
			for(int i = 0; i < 100; i++) {
				fileOut.write((int) (Math.random()*100) + " ");
			}
			
			fileOut.close();
			
			addFromData(data);
			
		} else {
			addFromData(data);
		}

	}
	
	private static void addFromData(File data) throws FileNotFoundException {
		int sum = 0;
		Scanner FileIn = new Scanner(data);
		
		while (FileIn.hasNext()) {
			sum += FileIn.nextInt();
		}
		
		System.out.println(sum);
		FileIn.close();
	}

}

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Exercise17_07 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try {
        	ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
            output.writeObject(loan1);
            output.writeObject(loan2);
            
            output.close();
            
        }
        catch (IOException ex) {
            System.out.println("File could not be opened");
        
        }
        
        File data = new File("Exercise17_07.dat");
        try {
			outputData(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	private static void outputData(File data) throws ClassNotFoundException, IOException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
		Scanner file = new Scanner(data);
		try {		
			while(true) {
				Loan loan = (Loan) in.readObject();
				System.out.println(loan.getLoanAmount());
			}
			
		}catch(EOFException ex) {
			file.close();
			in.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Did not work part 1");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Did not work part 2");
			e.printStackTrace();
		}
	}

}

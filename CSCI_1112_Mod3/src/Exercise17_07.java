import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Exercise17_07 {

	public static void main(String[] args) {
		
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
        outputData(data);

	}
	
	private static void outputData(File data) {
		
	}

}

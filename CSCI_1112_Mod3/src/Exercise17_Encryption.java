import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise17_Encryption {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("For Exercise 17-14 enter 1"
				+ "\nFor Exercise 17-15 enter 2");
		int pathchoice = in.nextInt();
		if (pathchoice == 1) {
			Exercise17_14();
		} else if (pathchoice == 2) {
			Exercise17_15();
		}
		in.close();
	}
	
	public static void Exercise17_14() throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the name of a file to pull from to encrypt"
				+ "\nFor pre made file enter File");
		String fileName = in.next();
		FileInputStream inFile;
		if (fileName.equals("File")) {
			inFile = new FileInputStream("Exercise17_14.dat");
		} else {
			inFile = new FileInputStream(fileName + ".dat");
		}
		
		System.out.println("Please enter the name of a file to push the encryption to"
				+ "\nFor pre made file enter File");

		fileName = in.next();
		FileOutputStream outFile;
		if (fileName.equals("File")) {
			outFile = new FileOutputStream("Exercise17_14enc.dat");
		} else {
			outFile = new FileOutputStream(fileName + ".dat");
		}
		
		try{
			while (true) {
				int encrypt = inFile.read();
				encrypt += 5;
				outFile.write(encrypt);
			}
		}
		catch(EOFException ex) {
			outFile.close();
			inFile.close();
			in.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Did not work part 1");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Did not work part 2");
			e.printStackTrace();
		}
		
		System.out.println("Encryption compleate");
	}

	public static void Exercise17_15() throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the name of a file to pull from to decryptcrypt"
				+ "\nFor pre made file enter File");
		String fileName = in.next();
		FileInputStream inFile;
		if (fileName.equals("File")) {
			inFile = new FileInputStream("Exercise17_14enc.dat");
		} else {
			inFile = new FileInputStream(fileName + ".dat");
		}
		
		System.out.println("Please enter the name of a file to push the decryption to"
				+ "\nFor pre made file enter File");
		fileName = in.next();
		FileOutputStream outFile;
		if (fileName.equals("File")) {
			outFile = new FileOutputStream("Exercise17_14.dat");
		} else {
			outFile = new FileOutputStream(fileName + ".dat");
		}
		
		try{
			while (true) {
				int decrypt = inFile.read();
				decrypt -= 5;
				outFile.write(decrypt);
			}
		}
		catch(EOFException ex) {
			outFile.close();
			inFile.close();
			in.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Did not work part 1");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Did not work part 2");
			e.printStackTrace();
		}

		System.out.println("Decryption compleate");
	}
	
}

import java.util.Scanner;

public class Exercise18_03 {

	public static void main(String[] args) {
		Scanner In = new Scanner(System.in);
		System.out.println("Please enter two integers");
		int a = In.nextInt();
		int b = In.nextInt();
		if (a >= b) {
			System.out.println("The greatest common divisor of " + a + " and " 
					+ b + " is " + GDP(a, b));
		} else {
			System.out.println("The greatest common divisor of " + a + " and " 
					+ b + " is " + GDP(b, a));
		}
		In.close();
	}

	private static int GDP(int m, int n) {
		if (m % n == 0) {
			return n;
		} else {
			return GDP(n, m % n);
		}
	}
}


public class Exercise18_09 {

	public static void main(String[] args) {
		String string = "gnikrow";
		reverceDisplay(string);
	}
	
	private static void reverceDisplay(String value) {
		if (!value.isEmpty()) {
		String flipper = new String();
		for (int i = 0; i < value.length() - 1; i++) {
			flipper = flipper + value.charAt(i);
		}
		System.out.print(value.charAt(value.length() - 1));
		reverceDisplay(flipper);
		}
	}	
}

package JavaProgrames;

public class IntegerPalindrome {

	public static void main(String[] args) {
		int a = 200;
		String str = Integer.toString(a);
		String rev = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		int Int1 = Integer.parseInt(rev);
		if (a == Int1) {
			System.out.println("Given number is palindrome");

		} else {
			System.out.println("Given number is not palindrome");
		}

	}

}

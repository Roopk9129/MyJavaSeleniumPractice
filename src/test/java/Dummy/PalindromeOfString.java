package Dummy;

public class PalindromeOfString {

	public static void main(String[] args) {
		String str = "ayamalyalammadam";
		int len = str.length() - 1;
		int a = 3;
		StringBuilder revString = new StringBuilder();
		String actualStr = "";
		for (int i = 0; i <= len; i++) {
			for (int j = 1; j < len; j++) {
				actualStr=actualStr+""+str.charAt(i);
				revString.append(actualStr);
				StringBuilder revst = revString.reverse();
				System.out.println(revst);
			}

		}
	}

}

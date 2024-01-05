package neww;


public class CombiNumbers {

	public static void main(String[] args) {
		String st = "aabbccc1234vv711jljh44";
		String digit = "";
		
		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			if (Character.isDigit(ch)) {
				String str = Character.toString(ch);
				digit = digit + str;
			}
		}
		for (int x = digit.length() - 1; x >= 0; x--) {
			System.out.print(digit.charAt(x));
		}
	}
}

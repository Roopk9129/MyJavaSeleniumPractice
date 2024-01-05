package neww;

public class DecimalValidation {
	public static void main(String[] args) {
		String st = "72.58";
		String[] sp = st.split("[.]");
		for (int i = 0; i < sp[1].length(); i++) {
			if (Character.isDigit(sp[1].charAt(i))) {
				int value = Integer.parseInt(String.valueOf(sp[1].charAt(i)));
				if (value >= 0) {
					System.out.println(sp[1].charAt(i) + " is " + "the Int");
				}
			}
		}
	}
}

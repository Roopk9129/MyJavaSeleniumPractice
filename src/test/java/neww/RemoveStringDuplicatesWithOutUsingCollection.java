package neww;

public class RemoveStringDuplicatesWithOutUsingCollection {

	public static void main(String[] args) {
		String str = "aaabbcddd";
		String st = new String();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) != str.charAt(j)) {
					st = st + str.charAt(i);
					break;
				}
			}
		}
		System.out.println(st);
	}
}

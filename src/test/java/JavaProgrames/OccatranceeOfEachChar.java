package JavaProgrames;

import java.util.LinkedHashSet;

public class OccatranceeOfEachChar {

	public static void main(String[] args) {
		String str = "acdcbhb";
		LinkedHashSet<Character> set = new LinkedHashSet<>();

		for (int i = 0; i < str.length(); i++) {
			set.add(str.charAt(i));
			int count = 0;
			for (Character ch : set) {
				if (ch == str.charAt(i)) {
					count++;
				}
				System.out.println(str.charAt(i) + " " + count);
			}
		}
	}
}

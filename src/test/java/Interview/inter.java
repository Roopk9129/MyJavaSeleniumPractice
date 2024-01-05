package Interview;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class inter {

	public static void main(String[] args) {
		String str = "Roop kumar is giving thee interview";
		String strLo = str.toLowerCase();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < strLo.length(); i++) {
			map.put(strLo.charAt(i), 1);
		}
		for (Entry<Character, Integer> m : map.entrySet()) {
			int num = 0;
			for (int i = 0; i < strLo.length(); i++) {
				if (m.getKey() == strLo.charAt(i)) {
					num++;
				}
			}
			System.out.println("The Character " + m.getKey() + " is repeating " + "" + num + " time");
		}
	}
}
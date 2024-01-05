package ListOfPrograms;

import java.util.LinkedHashMap;

public class p1 {
	public static void main(String[] args) {
		String str = "roop";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		System.out.println(map.entrySet());
	}
}
package neww;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class OrderOfOccaranceUsingMap {

	public static void main(String[] args) {
		String str = "Testyantra";
		String strL = str.toLowerCase();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < strL.length(); i++) {
			map.put(strL.charAt(i), i);
		}
		for (Entry<Character, Integer> m : map.entrySet()) {
			int count = 0;
			for (int i = 0; i < strL.length(); i++) {
				if (m.getKey() == strL.charAt(i)) {
					count++;
				}
			}
			System.out.println(m.getKey() + " " + count);
		}
	}
}

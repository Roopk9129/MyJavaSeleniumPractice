package Interview;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class OccaranceOfEachNumber {
	public static void main(String[] args) {
		int n = 122123;
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		for (; n != 0;) {
			int m = n % 10;
			if (map.containsKey(m)) {
				map.put(m, 1 + map.get(m));
			} else {
				map.put(m, 1);
			}
			n = n / 10;
		}
		for (Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > 1) {
				System.out.println("number " + '"' + e.getKey() + '"' + " is repeating " + e.getValue() + " time");
			}
		}
	}
}
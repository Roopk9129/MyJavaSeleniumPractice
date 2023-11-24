package ListOfPrograms;

import java.util.LinkedHashSet;

public class RemoveDuplicateWords3rdProg {

	public static void main(String[] args) {
		String str = "i am am roop";
		String[] sp = str.split(" ");
		LinkedHashSet<String> set = new LinkedHashSet<>();
		for (int i = 0; i < sp.length; i++) {
			set.add(sp[i]);
		}
		Object[] arr = set.toArray();
		for (Object obj : arr) {
			System.out.print(obj + " ");
		}
	}

}

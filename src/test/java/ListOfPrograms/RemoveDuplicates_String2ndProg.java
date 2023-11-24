package ListOfPrograms;

import java.util.*;

public class RemoveDuplicates_String2ndProg {
	public static void main(String[] args) {
		String st = "goosebumps";
		char[] ch = st.toCharArray();
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		for (int i = 0; i < ch.length; i++) {
			set.add(ch[i]);
		}
		Object[] arr = set.toArray();
		for (Object chh : arr) {
			System.out.print(chh);
		}
	}
}

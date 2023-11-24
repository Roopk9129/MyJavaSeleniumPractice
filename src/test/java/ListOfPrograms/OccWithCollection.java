package ListOfPrograms;

import java.util.LinkedHashSet;

public class OccWithCollection {

	public static void main(String[] args) {
		String str = "aabbcabd";
		char[] ch = str.toCharArray();
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		for (int i = 0; i < ch.length; i++) {
			set.add(ch[i]);
		}
		
		for(Character c:set) {
			int count=0;
			for(int i=0;i<ch.length;i++) {
				if(c==ch[i]) {
					count++;
				}
			}
			System.out.println(c+" "+count);
		}
	}
}

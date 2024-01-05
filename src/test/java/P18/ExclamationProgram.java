package P18;

import java.util.LinkedList;


public class ExclamationProgram {
	public static void main(String[] args) {
		String str = "hi! ho!w !are y!ou";
		String res = new String();
		String[] spl = str.split(" ");

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < spl.length; i++) {
			for (int j = 0; j < spl[i].length(); j++) {
				if (spl[i].charAt(j) == '!') {
					list.add(j);
				}
			}
			for (int x = spl[i].length() - 1; x >= 0; x--) {
				if (spl[i].charAt(x) != '!'  ) {
					res = res + spl[i].charAt(x);
				}
			}
		}
		System.out.println(res);
		Object[] arr = list.toArray();
		for (Object obj : arr) {
			System.out.println(obj);
		}
	}
}
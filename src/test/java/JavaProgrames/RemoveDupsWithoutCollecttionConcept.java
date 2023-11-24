package JavaProgrames;

public class RemoveDupsWithoutCollecttionConcept {

	public static void main(String[] args) {
		String str = "dummy";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					sb.append(str.charAt(i));
				}
			}
		}
		System.out.println(sb);
	}

}

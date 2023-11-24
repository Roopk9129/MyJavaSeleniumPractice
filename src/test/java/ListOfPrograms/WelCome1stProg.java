package ListOfPrograms;

public class WelCome1stProg {

	public static void main(String[] args) {
		/**
		 * input: wlecom to expleo output: expleo to welcome
		 */
		String str = "wlecom to expleo";

		String[] spstr = str.split(" ");
		
		String temp;
		temp = spstr[0];
		spstr[0] = spstr[2];
		spstr[2] = temp;
		
		char[] chc = spstr[2].toCharArray();
		char tempch=chc[2];
		chc[2]=chc[1];
		chc[1]=tempch;

//		char p2 = spstr[2].charAt(2);
//		char p1 = spstr[2].charAt(1);
//
//		char tempch = p2;
//		p2 = p1;
//		p1 = tempch;

		for (String st : spstr) {
			System.out.print(st + " ");

		}
	}

}

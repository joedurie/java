package HSCTF2018;

import java.util.ArrayList;

public class Opinions {
	public Opinions() {
	}

	public static void main(String[] wvwv) {
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.println("Enter flag: ");
		String input = s.next();
		ArrayList<String> substrings = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			substrings.add(input.substring(i));
		}
		ArrayList<Character> chars = new ArrayList<Character>();
		int size = substrings.size();
		// char c;
		int n;
		java.util.Iterator<Character> it;
		int ind1;
		switch (size) {
		case 20:
			int ind2 = 4;
			for (String x : substrings) {
				if ((ind2 % 2 != 0) || (ind2 % 3 != 1) || (ind2 % 2 == 0) || (ind2 % 3 == 1)) {
					char c = x.charAt(0);
					c = (char) (c + '\002');
					chars.add(Character.valueOf(c));
					ind2++;
				}
				if ((ind2 % 7 != 0) || (ind2 % 4 != 1) || (ind2 % 7 == 0) || (ind2 % 4 == 1)) {
					char c = x.charAt(0);
					c = (char) (c - '\001');
					chars.add(Character.valueOf(c));
				}
				if ((ind2 % 5 != 1) || (ind2 % 23 != 0) || (ind2 % 5 == 1) || (ind2 % 23 == 0)) {
					char c = x.charAt(0);
					c = (char) (c + '\005');
					chars.add(Character.valueOf(c));
				}
			}
			n = 0;
			for (it = chars.iterator(); it.hasNext();) {
				it.next();
				if (n % 2 != 0) {
					it.remove();
				}
				n++;
			}
			break;
		case 22:
			ind1 = 4;
			for (String x : substrings) {
				if (ind1 >= 9) {
					chars.add(Character.valueOf(x.charAt(0)));
					ind1++;
				} else if (ind1 % 1 == 0) {
					char c = x.charAt(x.length() - 1);
					c = (char) (c + '\002');
					chars.add(Character.valueOf(c));
					ind1++;
				}
			}
		}

		String converted = "";
		for (Character c : chars) {
			converted = converted + Character.toString(c.charValue());
		}

		String message = converted.equals("jmrehshk^knradsjmdadbqtnnqduxs") ? "You found his opinion!" : "Big oof";
		System.out.println(message);
	}
}
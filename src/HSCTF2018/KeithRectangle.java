package HSCTF2018;
import java.awt.Rectangle;
import java.util.Scanner;
public class KeithRectangle {

	public static void main(String[] args) {
		SecondClass[] sc = new SecondClass[6];
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] inputArray = input.split("-");
		scan.close();
		if (inputArray[1].length() != 8 || inputArray.length > 2) {
			System.out.println("Fail! Check INPUT");
			System.exit(0);
		}
		// Part 1
		int y = 1;
		int x = 0;
		int z = Integer.parseInt(inputArray[0]);
		int result = 0;
		while (x < 6) {
			sc[x] = new SecondClass(y);
			y = y * z;
			x++;
		}
		while (x > 0) {
			x--;
			result += sc[x].getValue(x);
		}
		System.out.println(result);
		//Part 2
		if (Integer.toString(result).length() != 8) {
			System.out.println("Fail! Check INPUT");
			System.exit(0);
		}
		String coord = "";
		int temp;
		char[] key = {'-', '-', '+', '+', '+', '-', '+', '+'};
		for (int i = 0; i < 8; i++) {
				if (key[i] == '+') {
					temp = Character.getNumericValue(inputArray[1].charAt(i)) + Character.getNumericValue(Integer.toString(result).charAt(i));
					if (temp < 10) {
						coord += Integer.toString(temp);
					} else {
						System.out.println("Fail! Check 0a");
						System.exit(0);
					}
				} else {
					temp = Character.getNumericValue(Integer.toString(result).charAt(i)) - Character.getNumericValue(inputArray[1].charAt(i));
					if (temp > -1) {
						coord += Integer.toString(temp);
					} else {
						System.out.println("Fail! Check 0b");
						System.exit(0);
					}
				}
		}
		
		//Part 3
		Rectangle[] mArray = getRect(coord);
		if (mArray[1].getWidth() * mArray[1].getHeight() < mArray[2].getWidth() * mArray[2].getHeight() && mArray[1].getX() == mArray[2].getX()) {
			if ((int)(Math.pow(mArray[1].getHeight() - 5, 2) + Math.pow(mArray[2].getWidth() - 5, 2)) == 5*5) {
				if (mArray[0].equals(new Rectangle(5, 5, 5, 5))) System.out.println("Correct! The flag is: " + input);
				else System.out.println("Fail! Check 3");
			} else {
				System.out.println("Fail! Check 2");
			}
		} else {
			System.out.println("Fail! Check 1");
		}
	}
	 
	public static Rectangle[] getRect (String s) {
		int[] thisArray = new int[8];
		for (int i = 0; i < 8; i++) {
			thisArray[i] = Character.getNumericValue(s.charAt(i));
		}
		Rectangle a = new Rectangle(thisArray[0], thisArray[1], thisArray[2], thisArray[3]);
		Rectangle b = new Rectangle(thisArray[4], thisArray[5], thisArray[6], thisArray[7]);
		Rectangle[] returnThis = {a.intersection(b), a, b};
		
		return returnThis;
	}
	
}
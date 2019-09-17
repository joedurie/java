package HSCTF2018;

import java.io.PrintStream;

public class TheSafe {
	public TheSafe() {
	}

	public static void main(String[] args) {
		int[] FLAG = {1,3,2,7,4,5,9,6,8,14,13,15,12,17,16,19,300,18,10,11};
		for(int i:FLAG)
			System.out.print(i+" ");
		System.out.println();
		int[] pass = new int[FLAG.length];
		int ans;
		for (int i = 1; i <= 19; i++) {
			ans = random(FLAG, i);
			pass[(i - 1)] = ans;
		}
		String oof = "";
		for (int i : pass) {
			oof = oof + Integer.toBinaryString(i) + " ";
		}
		if (oof.equals("0 10 1 100 101 111 11 1000 110 10010 10011 1100 1010 1001 1011 1110 1101 10001 1111 0 ")) {
			System.out.println("You have found the flag!");
		} else
			System.out.println("You just got robbed");
	}

	public static int random(int[] a, int key) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == key)
				return i;
		}
		return -1;
	}
}
package HSCTF2018;
public class Spoilers {
	public static void main(String[]args){
		String s="xrvguxvyyrqqhzoyrqber";
		for(int i=0;i<26;i++){
			for(char c:s.toCharArray()){
				int x=c+i;
				while(x>122)
					x=96+(x-122);
				System.out.print((char)x);
			}
			System.out.println();
		}
	}
}
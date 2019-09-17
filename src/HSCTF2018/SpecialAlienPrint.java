package HSCTF2018;
public class SpecialAlienPrint {
	public static void main(String[]args){
		String s="Hello, how've you been?";
		String converted="";
		for(char c:s.toCharArray())
			converted+="("+(127-c)+")";
		System.out.println("%$"+converted+"^$");
		System.out.println(-1%4);
	}
}
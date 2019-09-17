package HSCTF2018;
public class TeacherStruggles {
	public static void main(String[]args){
		String s="zkdxmxkhvgofoqvyeccuxokfimbtyhrbkpougnvzbhseotymydwbadenbzxrzfanxetkvyiczvoybearnqszydnwhrjamlpcqfxi";
		int x=0;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)=='h')
				x++;
			else if(s.charAt(i)=='s')
				x=2*(x+1);
			else if(s.charAt(i)=='c')
				x=3*(x+1);
			else if(s.charAt(i)=='t')
				x=4*(x+1);
			else if(s.charAt(i)=='f')
				x=5*(x+1);
		System.out.print(x);
	}
}
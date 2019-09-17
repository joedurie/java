package HSCTF2018;
public class OK {
	public static void main(String[]args){
		int[]oo=new int[1001],kk=new int[1001];
		oo[0]=0;
		kk[0]=0;
		for(int i=1;i<oo.length;i++){
			kk[i]=(oo[i-1]+kk[i-1])%1000000007;
			oo[i]=(oo[i-1]+kk[i-1])%1000000007;
			if(i%2==0)
				oo[i]++;
		}
		System.out.println(oo[1000]);
	}
}
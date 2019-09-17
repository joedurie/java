package cfhello2019;
import java.util.*;
public class D {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		long v=sc.nextLong(),k=sc.nextLong();
		sc.close();
		LinkedList<Long>facts=new LinkedList<Long>();
		for(long i=(long)Math.floor(Math.sqrt(v));i>0;i--)
			if(v%i==0){
				facts.addFirst(i);
				if(v/i!=i)
					facts.addLast(v/i);
			}
		long[]factArr=new long[facts.size()];
		HashMap<Integer,HashSet<Integer>>map=new HashMap<Integer,HashSet<Integer>>();
		for(int i=0;i<factArr.length;i++){
			factArr[i]=facts.removeFirst();
			map.put(i,new HashSet<Integer>());
			for(int j=0;j<=i;j++)
				if(factArr[i]%factArr[j]==0)
					map.get(i).add(j);
		}
		Fraction[][]mat=new Fraction[factArr.length][factArr.length];
		Fraction[][]matOrig=new Fraction[factArr.length][factArr.length];
		for(int c=0;c<mat.length;c++){
			for(int r=0;r<mat.length;r++)
				if(r<=c&&map.get(c).contains(r)){
					mat[r][c]=new Fraction(1,map.get(c).size());
					matOrig[r][c]=new Fraction(1,map.get(c).size());
				}else{
					mat[r][c]=new Fraction(0,1);
					matOrig[r][c]=new Fraction(0,1);
				}
		}
		int times=1;
		while(times<k){
			if(times>k/2.0||(long)Math.floor(Math.log(k/times)/Math.log(2))==(long)Math.floor(Math.log(k/(times+1))/Math.log(2))){
				times++;
				mat=multiply(mat,matOrig);
			}else{
				times*=2;
				mat=multiply(mat,mat);
			}
		}
		Fraction fin=new Fraction(0,1);
		for(int i=0;i<mat.length;i++)
			fin=fin.add(new Fraction(factArr[i],1).mult(mat[i][mat.length-1]));
		System.out.println(fin.modForm());
	}
	public static Fraction[][]multiply(Fraction[][]m1,Fraction[][]m2){
		Fraction[][]temp=new Fraction[m1.length][m1.length];
		for(int c=0;c<m2.length;c++){
			for(int r=0;r<m1.length;r++){
				Fraction sum=new Fraction(0,1);
				for(int x=0;x<m1.length;x++)
					sum=sum.add(m2[x][c].mult(m1[r][x]));
				temp[r][c]=sum;
			}
		}
		return temp;
	}
	public static class Fraction{
		long num;
		long denom;
		long mod=1000000007;
		public Fraction(long n,long d){
			num=n;
			denom=d;
			simplify();
		}
		public Fraction add(Fraction f){
			return new Fraction(num*f.denom+denom*f.num,denom*f.denom);
		}
		public Fraction mult(Fraction f){
			return new Fraction(num*f.num,denom*f.denom);
		}
		public void simplify(){
			if(num==0)
				denom=1;
			else{
				long a=Math.max(num,denom),b=Math.min(num,denom);
				while(a!=b&&a%b!=0){
					long temp=Math.max(b, a-b);
					b=Math.min(b,a-b);
					a=temp;
				}
				num/=b;
				denom/=b;
			}
		}
		public long modForm(){
			return num*pow(denom,mod-2)%mod;
		}
		public String toString(){
			return num+"/"+denom;
		}
		public long pow(long a,long p){
			if(p==1)
				return a;
			long half=pow(a,p/2);
			return ((half*half%mod)*(p%2==1?a:1))%mod;
		}
	}
}

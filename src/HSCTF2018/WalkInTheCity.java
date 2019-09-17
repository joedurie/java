package HSCTF2018;
public class WalkInTheCity{
	public static int n=1;
	public static void main(String[]args){
		long[][]roads=new long[10][10];
		roads[0]=new long[]{650,507,771,621,1000,555,691,560,598,502};
		roads[1]=new long[]{521,549,548,716,627,725,949,929,685,859};
		roads[2]=new long[]{716,551,572,608,676,886,802,826,963,905};
		roads[3]=new long[]{592,801,871,791,949,568,779,694,730,936};
		roads[4]=new long[]{812,874,913,994,548,910,830,862,664,839};
		roads[5]=new long[]{695,801,590,975,675,739,839,831,740,631};
		roads[6]=new long[]{944,714,674,792,942,864,603,871,992,919};
		roads[7]=new long[]{673,828,976,671,889,895,721,641,774,775};
		roads[8]=new long[]{805,536,738,960,729,708,563,635,798,691};
		roads[9]=new long[]{905,539,986,859,860,630,967,914,858,777};
		long[][]temp1=new long[10][10];
		long[][]temp2=new long[10][10];
		doubleN(temp1,roads);
		while(n<Math.pow(2, 20)){
			doubleN(temp2,temp1);
			if(n<Math.pow(2, 20))
				doubleN(temp1,temp2);
		}
		while(n<Math.pow(5, 9)){
			incrementN(temp2,temp1,roads);
			if(n<Math.pow(5, 9))
				incrementN(temp1,temp2,roads);
		}
		while(n<1000000000){
			doubleN(temp1,temp2);
			if(n<1000000000)
				doubleN(temp2,temp1);
		}
		long sum=0;
		for(int r=0;r<roads.length;r++)
			for(int c=0;c<roads.length;c++)
				sum=(sum+temp1[r][c])%1000000000000000L;
		System.out.println(n+"\n"+sum);
	}
	public static void doubleN(long[][]nextStep,long[][]lastStep){
		for(int r=0;r<lastStep.length;r++)
			for(int c=0;c<lastStep.length;c++){
				long sum=0;
				for(int j=0;j<lastStep.length;j++)
					sum+=lastStep[r][j]*lastStep[j][c];
				nextStep[r][c]=sum%1000000000000000L;
			}
		n*=2;
	}
	public static void incrementN(long[][]nextStep,long[][]lastStep,long[][]roads){
		for(int r=0;r<roads.length;r++)
			for(int c=0;c<roads.length;c++){
				long sum=0;
				for(int j=0;j<roads.length;j++)
					sum+=lastStep[r][j]*roads[j][c]%1000000000000000L;
				nextStep[r][c]=sum;
			}
		n++;
	}
}
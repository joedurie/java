package lanqiao2018;
import java.util.Scanner;
public class B {
	private static int[]daysInMonth={31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int start=sc.nextInt();
		int end=sc.nextInt();
		sc.close();
		int specialCount=0;
		while(start<=end){
			if(isSpecial(start))
				specialCount++;
			start=increment(start);
		}
		System.out.println(specialCount);
	}
	public static boolean isSpecial(int date){
		String s=date+"";
		int currentLen=1;
		int maxLen=1;
		for(int i=1;i<s.length();i++)
			if(s.charAt(i)==s.charAt(i-1))
				currentLen++;
			else{
				if(currentLen>maxLen)
					maxLen=currentLen;
				currentLen=1;
			}
		if(currentLen>maxLen)
			maxLen=currentLen;
		return maxLen>=3;
	}
	public static int increment(int date){
		int year=date/10000;
		int month=(date%10000)/100;
		int day=date%100;
		if(year%4==0&&month==2&&day==28)
			return Integer.parseInt(year+"0229");
		day++;
		if(day>daysInMonth[month-1]){
			month++;
			day=1;
		}
		if(month==13){
			year++;
			month=1;
		}
		String spacer1="",spacer2="";
		if(month<10)
			spacer1="0";
		if(day<10)
			spacer2="0";
		return Integer.parseInt(year+spacer1+month+spacer2+day);
	}
}
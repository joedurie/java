package cf532d2;
import java.util.*;
public class D {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int[][]rooks=new int[666][2];
		for(int i=0;i<666;i++)
			rooks[i]=new int[]{sc.nextInt(),sc.nextInt()};
		int[]king=new int[2];
		king=new int[]{sc.nextInt(),sc.nextInt()};
		boolean done=false;
		while(!done&&(king[0]!=500||king[1]!=500)){
			move(rooks,king,king[0]==500?0:(king[0]>500?-1:1),king[1]==500?0:(king[1]>500?-1:1));
			int p=sc.nextInt();
			if(p<=0)
				done=true;
			else
				rooks[p-1]=new int[]{sc.nextInt(),sc.nextInt()};
		}
		if(!done){
			int rI=0,rII=0,rIII=0,rIV=0;
			for(int i=0;i<666;i++)
				if(rooks[i][0]>494&&rooks[i][1]<494)
					rIII++;
				else if(rooks[i][0]>494&&rooks[i][1]>494)
					rIV++;
				else if(rooks[i][0]<494&&rooks[i][1]<494)
					rII++;
				else
					rI++;
			int dx=1,dy=1;
			if(rI<=rII&&rI<=rIII&&rI<=rIV){
				dx*=-1;
			}else if(rIII<=rII&&rIII<=rIV){
				dy*=-1;
			}else if(rIV<=rII){
				dx*=-1;
				dy*=-1;
			}
			while(!done){
				move(rooks,king,dx,dy);
				done=sc.nextInt()==-1&&sc.nextInt()==-1&&sc.nextInt()==-1;
			}
		}
		sc.close();
	}
	public static void move(int[][]rooks,int[]king,int dx,int dy){
		boolean r=false;
		for(int i=0;i<666;i++)
			if(rooks[i][0]==king[0]+dx&&rooks[i][1]==king[1]+dy)
				r=true;
		king[0]+=dx;
		if(!r)
			king[1]+=dy;
		System.out.println(king[0]+" "+king[1]);
		System.out.flush();
	}
}
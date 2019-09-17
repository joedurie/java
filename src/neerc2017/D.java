package neerc2017;
import java.util.*;
public class D {
	public static class Coord{
		int x,y,z;
		public Coord(int X,int Y,int Z){
			x=X;
			y=Y;
			z=Z;
		}
		public boolean equals(Object other){
			return other.hashCode()==hashCode();
		}
		public int hashCode(){
			return x*10000+y*100+z;
		}
		public String toString(){
			return x+" "+y+" "+z;
		}
	}
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		HashSet<Coord>voxels=new HashSet<Coord>();
		int xy=sc.nextInt(),xz=sc.nextInt(),yz=sc.nextInt();
		int x=-99,y=-99,z=-99;
		voxels.add(new Coord(-99,-99,-99));
		xy--;
		xz--;
		yz--;
		while((xy>0&&(xz>0||yz>0))||(xz>0&&yz>0)){
			if(xy==1&&xz==1&&yz==1){
				voxels.add(new Coord(-100,-100,-100));
				xy=0;
				yz=0;
				xz=0;
			}else if(xy<=xz&&xy<=yz){
				z++;
				xz--;
				yz--;
			}else if(xz<=xy&&xz<=yz){
				y++;
				xy--;
				yz--;
			}else if(yz<=xy&&yz<=xz){
				x++;
				xy--;
				xz--;
			}
			voxels.add(new Coord(x,y,z));
		}
		if(xy>0){
			int adds=1;
			while(adds>0&&xy>0){
				adds=0;
				HashSet<Coord>temp=new HashSet<Coord>();
				for(Coord a:voxels)
					for(Coord b:voxels)
						if(a.z==b.z){
							Coord one=new Coord(a.x,b.y,a.z),two=new Coord(b.x,a.y,a.z);
							if(xy>0&&!voxels.contains(one)&&!temp.contains(one)){
								xy--;
								adds++;
								temp.add(one);
							}
							if(xy>0&&!voxels.contains(two)&&!temp.contains(two)){
								xy--;
								adds++;
								temp.add(two);
							}
						}
				for(Coord c:temp)
					voxels.add(c);
			}
		}else if(xz>0){
			int adds=1;
			while(adds>0&&xz>0){
				adds=0;
				HashSet<Coord>temp=new HashSet<Coord>();
				for(Coord a:voxels)
					for(Coord b:voxels)
						if(a.y==b.y){
							Coord one=new Coord(a.x,a.y,b.z),two=new Coord(b.x,a.y,a.z);
							if(xz>0&&!voxels.contains(one)&&!temp.contains(one)){
								xz--;
								adds++;
								temp.add(one);
							}
							if(xz>0&&!voxels.contains(two)&&!temp.contains(two)){
								xz--;
								adds++;
								temp.add(two);
							}
						}
				for(Coord c:temp)
					voxels.add(c);
			}
		}else if(yz>0){
			int adds=1;
			while(adds>0&&yz>0){
				adds=0;
				HashSet<Coord>temp=new HashSet<Coord>();
				for(Coord a:voxels)
					for(Coord b:voxels)
						if(a.x==b.x){
							Coord one=new Coord(a.x,a.y,b.z),two=new Coord(a.x,b.y,a.z);
							if(yz>0&&!voxels.contains(one)&&!temp.contains(one)){
								yz--;
								adds++;
								temp.add(one);
							}
							if(yz>0&&!voxels.contains(two)&&!temp.contains(two)){
								yz--;
								adds++;
								temp.add(two);
							}
						}
				for(Coord c:temp)
					voxels.add(c);
			}
		}
		if(xy!=0||xz!=0||yz!=0)
			System.out.println(-1);
		else{
			System.out.println(voxels.size());
			for(Coord s:voxels)
				System.out.println(s);
		}
	}
}

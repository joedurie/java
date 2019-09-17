package neerc2017;
import java.io.*;
import java.util.*;
public class ITester {
	static int n;
	static int[]odds,left,len,oddIds;
	static ArrayList<Integer>eArr=new ArrayList<Integer>(),oArr=new ArrayList<Integer>();
	static MyScanner sc = new MyScanner();
	static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	public static void main(String[]args){
		n=sc.nextInt();
		generateAns();
		long startTime=System.nanoTime();
		odds=new int[(n+1)/2];
		left=new int[(n+1)/2];
		len=new int[(n+1)/2];
		oddIds=new int[(n+1)/2];
		len[0]=(n+1)/2;
		for(int i=0;i<odds.length;i++){
			odds[i]=i+1;
			left[i]=0;
		}
		LinkedList<Integer>evens=new LinkedList<Integer>();
		for(int i=1;i<=n/2;i++){
			evens.add(search(i,0,(n-1)/2));
			for(int x:odds)
				System.out.print(x+" ");
			System.out.println();
			for(int x:left)
				System.out.print(x+" ");
			System.out.println();
		}
		for(int i=0;i<(n+1)/2;i++)
			oddIds[odds[i]-1]=2*i+1;
		out.println(eArr);
		out.println(oArr);
		out.println();
		out.println(evens);
		for(int i:oddIds)
			out.print(i+" ");
		out.println();
		int eInd=0;
		for(int i:evens)
			if(i!=eArr.get(eInd++))
				out.print("YOU FUCKED IT UP");
		int oInd=0;
		for(int i:oddIds)
			if(i!=oArr.get(oInd++))
				out.print("YOU FUCKED IT UP");
		out.println();
		long endTime=System.nanoTime();
		out.println(count+" queries");
		out.println((endTime-startTime)/1000000000.0+" seconds");
		out.close();
	}
	static void generateAns(){
		ArrayList<Integer>list=new ArrayList<Integer>();
		for(int i=1;i<=n;i++)
			list.add(i);
		Collections.shuffle(list,new Random(1126588537^23452351));
		for(int i:list)
			if(i%2==0)
				eArr.add(i);
			else
				oArr.add(i);
	}
	static int getVal(int index,int start,int end){
		int mid=left[(start+end)/2];
		TreeSet<Integer>g=new TreeSet<Integer>(),l=new TreeSet<Integer>();
		for(int i=mid;i<mid+len[mid];i++)
			if(oddGreater(index,odds[i]))
				g.add(odds[i]);
			else
				l.add(odds[i]);
		int left2=mid+l.size(),right2=left2+g.size();
		if(l.size()>0)
			len[mid]=l.size();
		if(g.size()>0)
			len[left2]=g.size();
		for(int i=mid;i<left2;i++)
			odds[i]=l.pollFirst();
		for(int i=left2;i<right2;i++){
			left[i]=left2;
			odds[i]=g.pollFirst();
		}
		return 2*left2;
	}
	static int search(int index,int start,int end){
		int mid=left[(start+end)/2];
		if(mid==start&&mid+len[mid]==end+1)
			return getVal(index,start,end);
		if(oddGreater(index,odds[mid])){
			if(mid+len[mid]-1==end){
				int v=getVal(index,mid,mid+len[mid]-1);
				return v>2*mid?v:search(index,start,mid-1);
			}
			return search(index,start,mid+len[mid]-1);
		}else{
			if(mid==start){
				int v=getVal(index,mid,mid+len[mid]-1);
				return v<2*(mid+len[mid])?v:search(index,mid+len[mid],end);
			}
			return search(index,mid,end);
		}
	}
	static int count=0;
	static HashMap<String,Boolean>map=new HashMap<String,Boolean>();
	static boolean oddGreater(int e,int o){
		if(map.containsKey(e+" "+o))
			return map.get(e+" "+o);
		count++;
		out.println("? "+e+" "+o);
		out.flush();
		map.put(e+" "+o,oArr.get(o-1)>eArr.get(e-1));
		return oArr.get(o-1)>eArr.get(e-1);
	}
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

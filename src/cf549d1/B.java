package cf549d1;
import java.io.*;
import java.util.*;

public class B {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),m=sc.nextInt(),q=sc.nextInt();
		int[]perm=new int[n];
		int[]nextP=new int[n];
		int[]lastP=new int[n];
		for(int i=0;i<n;i++){
			perm[i]=sc.nextInt()-1;
			if(i>0){
				nextP[perm[i-1]]=perm[i];
				lastP[perm[i]]=perm[i-1];
			}
		}
		nextP[perm[n-1]]=perm[0];
		lastP[perm[0]]=perm[n-1];
		int[]arr=new int[m];
		for(int i=0;i<m;i++)
			arr[i]=sc.nextInt()-1;
		int[]len=new int[m];
		int[]ind=new int[m];
		int[]last=new int[n];
		int[]nInd=new int[m];
		for(int i=0;i<n;i++)
			last[i]=-1;
		for(int i=0;i<m;i++)
			nInd[i]=-1;
		for(int i=m-1;i>=0;i--){
			int j=last[nextP[arr[i]]];
			int k=last[lastP[arr[i]]];
			if(j==-1){
				len[i]=1;
				ind[i]=i;
			}else{
				len[i]=len[j]+1;
				ind[i]=ind[j];
				//if(j<=k)
				nInd[j]=i;
				System.out.print("J");
				if(len[i]>n){
					len[i]=n;
					ind[i]=nInd[ind[j]];
					System.out.print("IND:"+ind[j]+" "+nInd[ind[j]]+"FUCKDICK");
				}
			}
			System.out.println(i+" ++"+j+" "+(j>-1?nInd[j]:"P"));
			last[arr[i]]=i;
		}
		for(int i:arr)
			System.out.print(" "+(i+1)+" ");
		System.out.println();
		for(int i=0;i<m;i++)
			System.out.print((i<10?" ":"")+i+" ");
		System.out.println();
		for(int i:nInd)
			System.out.print((i>=0&&i<10?" ":"")+i+" ");
		System.out.println();
		for(int i:len)
			System.out.print((i<10?" ":"")+i+" ");
		System.out.println();
		for(int i:ind)
			System.out.print((i>=0&&i<10?" ":"")+i+" ");
		int sq=(int)Math.sqrt(m);
		int[]lkup=new int[(int)Math.ceil(m/(double)sq)];
		for(int i=0;i<lkup.length;i++)
			lkup[i]=Integer.MAX_VALUE;
		for(int i=0;i<m;i++)
			if(len[i]==n&&ind[i]<lkup[i/sq])
				lkup[i/sq]=ind[i];
		for(int w=0;w<q;w++){
			int l=sc.nextInt()-1,r=sc.nextInt()-1;
			int rOrig=r;
			int min=r+1;
			while(l%sq!=0&&l<r){
				if(len[l]==n)
					min=Math.min(ind[l],min);
				l++;
			}
			while(r%sq!=sq-1&&r>l){
				if(len[r]==n)
					min=Math.min(ind[r],min);
				r--;
			}
			if(len[l]==n)
				min=Math.min(min,ind[l]);
			while(l<=r){
				min=Math.min(lkup[l/sq],min);
				l+=sq;
			}
			out.print(min<=rOrig?"1":"0");
		}
		// ------------------------
		out.close();
	}
	//------------------------

	public static PrintWriter out;
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
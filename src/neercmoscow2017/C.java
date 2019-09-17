package neercmoscow2017;
import java.util.*;

public class C {
	static ArrayList<HashSet<Integer>> tree = new ArrayList<HashSet<Integer>>();
	static int[] x;
	static int[] y;
	static int[] ct;
	static int[] heavyCh;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		x = new int[n];
		y = new int[n];
		ct = new int[n];
		heavyCh = new int[n];
		for(int i = 0; i < n; i++) {
			tree.add(new HashSet<Integer>());
			heavyCh[i] = -1;
		}
		for(int i = 0; i < n - 1; i++) {
			int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		sc.close();
		fillCt(0);
		fillHeavy(0);
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int b = 0;
		while(b != -1) {
			ll.add(b);
			b = heavyCh[b];
		}
		processRow(1, ll);
		for(int i = 0; i < n; i++)
			System.out.println(x[i] + " " + y[i]);
	}
	static void processRow(int row, LinkedList<Integer> ll) {
		LinkedList<Integer> next = new LinkedList<Integer>();
		int currX = 1;
		for(int a : ll) {
			x[a] = currX++;
			y[a] = row;
			for(int b : tree.get(a))
				if(b != heavyCh[a])
					while(b != -1) {
						next.add(b);
						b = heavyCh[b];
					}
		}
		if(!next.isEmpty())
			processRow(row + 1, next);
	}
	static int fillCt(int i) {
		ct[i] = 1;
		for(int j : tree.get(i)) {
			tree.get(j).remove(i);
			ct[i] += fillCt(j);
		}
		return ct[i];
	}
	static void fillHeavy(int i) {
		for(int j : tree.get(i)) {
			fillHeavy(j);
			if(ct[j] >= (ct[i] + 1)/ 2)
				heavyCh[i] = j;
		}
	}
}

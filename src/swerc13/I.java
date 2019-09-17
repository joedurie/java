package swerc13;
import java.io.*;
import java.util.*;

public class I {
	public static void main(String[] args) throws NumberFormatException, IOException {
		out = new PrintWriter(new BufferedOutputStream(System.out));
		HashMap<String, Integer> sToI = new HashMap<String, Integer>();
		TreeMap<Integer, TreeSet<String>> iToS = new TreeMap<Integer, TreeSet<String>>();
		LinkedList<HashMap<String, Integer>> k = new LinkedList<HashMap<String, Integer>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = br.readLine()) != null) {
			//System.out.println(s);
			if(s.equals("<text>")) {
				HashMap<String, Integer> list = new HashMap<String, Integer>();
				String[] a = br.readLine().split(" ");
				//System.out.println(a[0]);
				while(!a[0].equals("</text>")) {
					for(String str : a)
						if(str.length() >= 4) {
							list.put(str, list.containsKey(str) ? list.get(str) + 1 : 1);
						}
					a = br.readLine().split(" ");
					//System.out.println(a[0]);
				}
				//System.out.println(sToI);
				//System.out.println(iToS);
				for(String str : list.keySet()) {
					int x = list.get(str);
					if(sToI.containsKey(str)) {
						iToS.get(sToI.get(str)).remove(str);
						if(!iToS.containsKey(sToI.get(str) + x))
							iToS.put(sToI.get(str) + x, new TreeSet<String>());
						iToS.get(sToI.get(str) + x).add(str);
						sToI.put(str, sToI.get(str) + x);
					} else {
						sToI.put(str, x);
						if(!iToS.containsKey(x))
							iToS.put(x, new TreeSet<String>());
						iToS.get(x).add(str);
					}
				}
				k.add(list);
				if(k.size() == 8) {
					HashMap<String, Integer> map = k.removeFirst();
					for(String str : map.keySet()) {
						int x = map.get(str), orig = sToI.get(str);
						iToS.get(orig).remove(str);
						if(!iToS.containsKey(orig - x))
							iToS.put(orig - x, new TreeSet<String>());
						iToS.get(orig - x).add(str);
						sToI.put(str, orig - x);
					}
				}
			} else if(s.length() > 0 && s.charAt(0) == '<') {
				String[] fuck = s.split(" ");
				int num = Integer.parseInt(fuck[1]);
				int ct = 0;
				out.println("<top " + num + ">");
				HashMap<Integer, TreeSet<String>> fix = new HashMap<Integer, TreeSet<String>>();
				while(ct < num) {
					int key = iToS.lastKey();
					for(String str : iToS.get(key))
						out.println(str + " " + key);
					ct += iToS.get(key).size();
					if(ct < num) {
						fix.put(key, iToS.get(key));
						iToS.remove(key);
					}
				}
				out.println("</top>");
				for(int x : fix.keySet())
					iToS.put(x, fix.get(x));
				fix.clear();
				//System.out.println("DONE");
			}
		}
		out.close();
	}
	public static PrintWriter out;
}

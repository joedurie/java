package HSCTF2018;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

public class PrimeSuspect {
    public static void main (String args[]){// throws JSONException{
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); 
        sc.close();
        //JSONObject data = new JSONObject("{\"KEITH\": \"HEY! Y U HERE.\",\"00f\": 13,\"powerinfo\": {\"DATCULPRIMETHO\": 2,\"DATPRIMETHO\": 17},\"NUMS\": [4, 3, 11, -9],\"ugotdameme\": \"Good job, the flag is \", \"thismany\": 10}");
        String[] inArrayString = input.split("-");
        
        String[] shuffled = shuffle(inArrayString,13); //rotates all values in inArrayString by 91
        int answer = parseData(shuffled);
        boolean noice = false;
        boolean contains = thisIsCool(350000).contains(answer);//returns whether answer is a prime under 350000
        
        long[] uniqueNums = theseAreHere(10);
        for (int i = 1; i < 11; i++) {
        	if (BigInteger.valueOf(uniqueNums[i]).gcd(BigInteger.valueOf(i)).longValue() == (((double)uniqueNums[i])/answer)) {
        		noice = true;
        	}
        }
           
        //JSONObject powerInfo = data.getJSONObject("powerinfo");
        if (contains && answer > Math.pow(2,17) && noice) {
            System.out.println("Good job, the flag is " + input);
        } else {
            System.out.println("no meme");
        }
        
    }
    
   
    
    static ArrayList<Integer> thisIsCool(int limit) { 
        ArrayList<Integer> primes = new ArrayList<Integer>();
        boolean [] booleanArray = new boolean [limit];
        final int sqrtSize = (int)Math.sqrt(limit); 
        for (int i = 2; i <= sqrtSize; i++) { //after this loop, primes are false (and stored in primes)
            if (!booleanArray [i]) { 
                primes.add(i);
                for (int j = i*i; j < booleanArray.length; j += i) 
                    booleanArray [j] = true;
            }
        }
        for (int i = sqrtSize + 1; i < limit; i++)
            if (!booleanArray [i])
                primes.add(i);
        return primes;
    }
    
   static String[] shuffle (String[] arr, int count) {
        int c=1;
        String[] a = Arrays.copyOfRange(arr, 0, arr.length);
        String[] b = Arrays.copyOfRange(arr, 0, arr.length);
        while(c<=count) { // values of a are moved (count(count+1)/2)%arr.length spaces around the array (91%size for the call in main)
            int index=0;
            while (index<arr.length) {
                a[(index+c)%arr.length]=b[index];
                index++;        
            }
            c++; 
            for (int n=0; n<a.length; n++) {
                b[n]=a[n];
            }        
        } 
        
        return a;
    }
    
    static int parseData(String[] input){
        int repCount = 0, sendCount = 0;
        StringBuilder out = new StringBuilder("");
        //JSONArray nums = data.getJSONArray("NUMS");
        int[]nums={4,3,11,-9};
        for (int i = 0; i < input.length; i++) {
	        if (input[i].length() > 3 && input[i].substring(0, 3).equals("REP")) {
	            repCount++;
	            int repIntNum = Integer.parseInt(input[i].substring(3));
	            if (repIntNum <= 1) {
	                System.out.println("o u bad.");
	                System.exit(0);
	            }
	            int repInt = 0, prev = -1;
	            i++;
	            while (!input[i].equals("END")) {
	            	int now = Integer.parseInt(input[i]);
	            	if (now > prev) {
	            		repInt += nums[now];
	            		prev = now;
	            	} else {
	            		System.out.println("no no no");
	            		System.exit(0);
	            	}
	                i++;
	            }
	            for (int j = 0; j < repIntNum; j++) {
	                out.append(repInt);
	            }
	        } else if (input[i].equals("SUM")) {
	        	sendCount++;
	        	int sumInt = 0;
	            i++;
	            int prev = -1;
	            while (!input[i].equals("END")) {
	            	int now = Integer.parseInt(input[i]);
	            	if (now > prev) {
	            		sumInt += nums[now];
	            		prev = now;
	            	} else {
	            		System.out.println("no no no");
	            		System.exit(0);
	            	}
	                i++;
	            }
	            out.append(sumInt);
	        } else {
	            System.out.println("whoopsie");
	            System.exit(0);
	        }
	        
        }
        if (repCount > sendCount) {
        	return Integer.parseInt(out.toString());
        } else {
            System.out.println("no u");
            System.exit(0);
            return 0;
        }
    }
    
    static long[] theseAreHere(int utryhard) {
    	long[] take = new long[utryhard+1];
    	take[1] = 9;
    	long forever;
    	for (int i = 2; i <= utryhard; i++) {
    		forever = (long)Math.pow(10, i);
    		for (int j = 1; j < i; j++) {
    			if (i % j == 0) forever /= take[j];
    		}
    		take[i] = forever;
    	}
    	return take;
    }
}
    

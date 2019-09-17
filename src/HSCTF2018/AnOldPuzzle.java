package HSCTF2018;
import java.util.*;
public class AnOldPuzzle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		String[] arr = input.split(":");
		if (arr.length == 2 && play(6, arr[0]) && play(0, arr[1])) {
			System.out.println("Congratulations, you won! The flag is: " + input);
		} else {
			System.out.println("Big Oof.");
		}
			
		}
	
	static ArrayList<String[][]> setVal() {
		String[][] map1 = {{"START", "_", "_", "e", "b"}, {"$", "1", "_", "g", "c"}, {"$", "$", "_", "p", "n"}, {"2", "_", "_", "t", "y"}, {"p", "m", "3", "$", "l"}};
		String[][] map2 = {{"j", "k", "$", "$", "2"}, {"v", "%", "_", "_", "_"}, {"_", "_", "1", "z", "x"}, {"%", "d", "f", "3", "a"}, {"q", "r", "%", "_", "i"}};
		String[][] map3 = {{"f", "_", "s", "%"}, {"$", "_", null , "$"}, {"$", "%", "!", "END"}, {"@", "$", "%", "_"}};
		ArrayList<String[][]> returnArr = new ArrayList<String[][]>();
		returnArr.add(map1);
		returnArr.add(map2);
		returnArr.add(map3);
		return returnArr;
	}
	
	static int[] makeMove (char current) throws Exception {
		int[] returnArr = new int[2];
		if (current == 'l') {
			returnArr[0] = 0;
			returnArr[1] = -1;
			return returnArr;
		} else if (current == 'r') {
			returnArr[0] = 0;
			returnArr[1] = 1;
			return returnArr;
		} else if (current == 'u') {
			returnArr[0] = -1;
			returnArr[1] = 0;
			return returnArr;
		} else if (current == 'd') {
			returnArr[0] = 1;
			returnArr[1] = 0;
			return returnArr;
		} else {
			throw new Exception();
		}
	}
	
	static String validate (String[][] graph, int r, int c) {
		if (graph[r][c].charAt(0) == '$') {
			return "$";
		} else if (Character.isDigit(graph[r][c].charAt(0))) {
			return "#";
		} else if (graph[r][c].charAt(0) == '%' || graph[r][c].charAt(0) == '_') {
			return "_";
		} else if (graph[r][c].equals("END")) {
			return "E";
		} else {
			return "X";
		}
	}
	
	static boolean play (int target, String input) {
		ArrayList<String[][]> maps = new ArrayList<String[][]>();
		maps = setVal();
		
		boolean playing = true, endReached = false;
		int i = 0, currentMap = 0, r = 0, c = 0, dollarCount = 0;
		int[] move = new int[2];
		String currentSquare;
		
		while (playing && i < input.length()) {
			
			maps.get(currentMap)[r][c] = "X";
			try {
				move = makeMove(input.charAt(i));
			} catch (Exception e) {
				System.out.println("INVALID MOVE");
				return false;
			}
	
			r += move[0]; c += move[1];
			if ((currentSquare = validate(maps.get(currentMap), r, c)) != "X") {
				if (currentSquare.equals("$")) {
					dollarCount++;
				} else if (currentSquare.equals("#")) {
					currentMap++;
					if (currentMap == 2) {
						c--;
					}
				} else if (currentSquare.equals("E")) {
					playing = false;
					endReached = true;
				}
			} else {
				return false;
			}
			i++;
		}
		
		if (endReached && dollarCount == target && i == input.length()) {
			return true;
		} else {
			return false;
		}
	}
}
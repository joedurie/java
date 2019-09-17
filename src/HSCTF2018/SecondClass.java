package HSCTF2018;
class SecondClass {
	int multiply;
	
	public SecondClass (int y) {
		multiply = y  - 100;
	}
	
	public int getValue(int input) {
		if (multiply > 100) {
			return multiply * input;
		} else {
			return multiply * (5 - input);
		}
	}
}
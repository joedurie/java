package HSCTF2018;
public class Point {
	private double x;
	private double y;
	public Point(double xVal,double yVal){
		x=xVal;
		y=yVal;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double distanceTo(Point other){
		return Math.sqrt(Math.pow(x-other.getX(),2)+Math.pow(y-other.getY(),2));
	}
}
package templates;
import java.util.*;
import static java.lang.Math.*;

public class LinearAlgebra {
	static int[][] matrixExpo(int[][]m, long p) {
		if(p==1)
			return m;
		int[][] x = matrixExpo(m, p/2);
		int[][] res = multiply(x, x);
		return p % 2 == 1 ? multiply(res, m) : res;
	}
	static int[][] multiply(int[][] m1, int[][]m2) {
		int[][] prod = new int[m1.length][m2[0].length];
		for(int i = 0; i < m1.length; i++)
			for(int j = 0; j < m2.length; j++)
				for(int k = 0; k < m2[0].length; k++)
					prod[i][k] += m1[i][j] * m2[j][k];
		return prod;
	}
	static double[][] inverse(double[][] m) {
		double[][] aug = new double[m.length][2*m.length];
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m.length; j++)
				aug[i][j] = m[i][j];
		for(int i = 0; i < m.length; i++)
			aug[i][m.length + i] = 1;
		rref(aug);
		double[][] inv = new double[m.length][m.length];
		for(int i = 0; i < m.length; i++)
			for(int j = 0; j < m.length; j++)
				inv[i][j] = aug[i][j + m.length];
		return inv;
	}
	static void rref(double[][] m) { //could be some bad d = 0 cases, make sure this can't happen
		for(int i = 0; i < m.length; i++){
			double d = m[i][i];
			for(int j = 0; j < m[i].length; j++)
				m[i][j] /= d;
			for(int k = 0; k < m.length; k++)
				if(k != i){
					d = m[k][i];
					for(int j = 0; j < m[i].length; j++)
						m[k][j] -= d * m[i][j];
				}
		}
	}
}

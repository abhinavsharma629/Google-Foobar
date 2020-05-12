/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Answer so=new Answer();
    for(int i=3;i<=200;i++){
      System.out.println(so.answer(i));
      System.out.println("--------------------------");
    }
	}
}

class Solution {
  public static int[][] mat = new int[201][201];

  public static int fillMatrix(int n) {
	    mat[1][1] = 1;
	    mat[2][2] = 1;

		for (int w=3; w<201;w++) {
			for (int m=1;m<=w;m++) {
				if (w-m == 0) {
					mat[w][m] = 1 + mat[w][m-1];

				} else if (w-m < m) {
					mat[w][m] =  mat[w-m][w-m] + mat[w][m-1];

        } else if (w-m == m) {
					mat[w][m] = mat[m][m-1] + mat[w][m-1];

				} else if (w-m >m) {
					mat[w][m] = mat[w-m][m-1] + mat[w][m-1];

				}
			}
		}
		return mat[n][n] - 1;
	}

	public static int solution(int n) {
		return fillMatrix(n);
	}
}

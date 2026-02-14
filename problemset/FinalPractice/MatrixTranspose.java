package finalsPractice;

import java.util.ArrayList;

import acm.program.ConsoleProgram;

public class MatrixTranspose extends ConsoleProgram{
	public void run() {
		int [][] matrix = { {6,7,3}, 
							{4,9,5}, 
							{1,2,4}
				};
		//we want to transpose the matrix (columns get rows and vice-versa).
		//assume that the given matrix is always quadratic!
		/*
		 * expected result:
		 * 6 4 1
		 * 7 9 2
		 * 3 5 4
		 */
		transposeMatrix(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				print(matrix[i][j] + " ");
			}
			println();
		}
	}

	private void transposeMatrix(int[][] matrix) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				a.add(matrix[j][i]);
			}
			//6 4 1 7 9 2 3 5 4
		}
		
		int cnt = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = a.get(cnt);
				cnt++;
			}
		}
	}
	
}

package finalsPractice;

import java.util.ArrayList;

import acm.program.ConsoleProgram;

public class MatrixRearrange extends ConsoleProgram{
	public void run() {
		int [][] matrix = { {6,7,3,8}, 
							{4,9,5,12}, 
							{1,23,4,17}
				};
		//we want to reverse the rows in the matrix.
		rearrangeMatrix(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				print(matrix[i][j] + " ");
			}
			println();
		}
	}

	private void rearrangeMatrix(int[][] matrix) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			a.clear();
			for (int j = 0; j < matrix[0].length; j++) {
				a.add(matrix[i][j]);
			}
			for (int k = 0; k < matrix[0].length; k++) {
				matrix[i][k] = a.get(matrix[0].length - 1 - k);
			}
		}
		
		
	}
	
}

package finalsPractice;

import java.util.ArrayList;

import acm.program.ConsoleProgram;

public class MatrixRearrange2 extends ConsoleProgram{
	public void run() {
		int [][] matrix = { {6,7,3,8}, 
							{4,9,5,12}, 
							{1,23,4,17}
				};
		//we want to reverse the columns in the matrix.
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
		for (int i = 0; i < matrix[0].length; i++) { //4
			a.clear();
			for (int j = 0; j < matrix.length; j++) { //3
				a.add(matrix[j][i]);
			}
			//6 4 1
			for (int k = 0; k < matrix.length; k++) {
				matrix[k][i] = a.get(matrix.length - 1 - k);
			}
		}
		
		
	}
	
}

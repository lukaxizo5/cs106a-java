package finalsPractice;

import java.util.ArrayList;
import java.util.Collections;

import acm.program.ConsoleProgram;

public class MatrixSort extends ConsoleProgram{
	public void run() {
		int [][] matrix = { {6,7,3,8}, 
							{4,9,5,12}, 
							{1,23,4,17}
							};
		sortMatrix(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				print(matrix[i][j] + " ");
			}
			println();
		}
	}
	
	private void sortMatrix(int[][] matrix) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				arr.add(matrix[i][j]);
			}
		}
		Collections.sort(arr);
		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = arr.get(k);
				k++;
			}
		}
	}
}

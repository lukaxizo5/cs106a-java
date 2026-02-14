import acm.program.ConsoleProgram;

public class Problem59 extends ConsoleProgram{
	public void run() {
		int[][] matrix = {
				{0,0,1,1,1},
				{1,1,1,1,1},
				{1,0,1,0,1},
				{0,0,1,1,1}
				};
		getMaxAreaRectangle(matrix);
	}

	private void getMaxAreaRectangle(int[][] matrix) {
		int max = 0;
		for (int i=0; i<matrix.length; i++){
			for (int j=0;j<matrix[0].length; j++){
				for (int k=i; k<matrix.length; k++){
					for (int l=j; l<matrix[0].length; l++){
						if (isPerfect(matrix,i,j,k,l)) {
							int currentArea = (k-i+1) * (l-j+1);
							max = Math.max(currentArea, max);
						}
					}
				}
			}
		}
		println(max);
	}

	private boolean isPerfect(int[][] matrix, int i, int j, int k, int l) {
		for (int a=i;a<=k;a++){
			for (int b=j;b<=l;b++){
				if (matrix[a][b]!=1) return false;
			}
		}
		return true;
	}
}

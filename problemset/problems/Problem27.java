import acm.program.ConsoleProgram;

public class Problem27 extends ConsoleProgram {
	public void run() {
		int n = readInt("Insert natural number: ");
		int m = readInt("Insert natural number: ");
		int power = 1;
		//println(Math.pow(n, m));
		while (m > 0){
			power*=n;
			m--;
		}
		println(power);		
	}

}
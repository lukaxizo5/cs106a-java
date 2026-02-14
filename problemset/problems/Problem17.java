import java.math.BigDecimal;

import acm.program.ConsoleProgram;

public class Problem17 extends ConsoleProgram {
	public void run() {
		double number = readDouble("Insert rael number here");
		BigDecimal sameNumber = new BigDecimal (""+number);
		println(sameNumber.intValue());
		println(sameNumber.remainder(BigDecimal.ONE));
	}

}
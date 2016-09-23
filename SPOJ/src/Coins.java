import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coins {

	static Map<Long, Long> mem = new HashMap<Long, Long>();
	static long max = 0;

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			long coinNumber = input.nextLong();
			max = 0;
			mem.clear();
			System.out.println(compute(coinNumber));
		}
		input.close();
	}

	private static long compute(long coinNumber) {

		if (coinNumber < 3)
			return coinNumber;

		if (mem.containsKey(coinNumber)) {
			return mem.get(coinNumber);
		}

		long sum = coinNumber / 2 + coinNumber / 3 + coinNumber / 4;

		if (coinNumber > sum) {
			mem.put(coinNumber, coinNumber);
			return coinNumber;
		} else {
			long result = compute(coinNumber / 2) + compute(coinNumber / 3) + compute(coinNumber / 4);
			mem.put(coinNumber, result);
			return result;
		}
	}
}
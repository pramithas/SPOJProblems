import java.util.Scanner;

public class Scode {

	static long dp[] = new long[5001];

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		dp[0] = 1;
		String inputString = "";
		while (input.hasNext()) {
			inputString = input.nextLine();
			if (inputString.equals("0")) {
				break;
			}
			reset(dp);
			compute(inputString);
			System.out.println(dp[inputString.length()]);
		}

		input.close();
	}

	private static void reset(long[] dp2) {
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 0;
		}
	}

	private static void compute(String inputString) {
		for (int i = 0; i < inputString.length(); i++) {
			if (isValidOneDigit(inputString.charAt(i) + "")) {
				dp[i + 1] = dp[i];
			}

			if (i > 0) {
				String subString = inputString.substring(i - 1, i + 1);

				if (isValidTwoDigit(subString)) {
					dp[i + 1] += dp[i - 1];
				}
			}

		}
	}

	private static boolean isValidTwoDigit(String subString) {

		if (26 >= Long.parseLong(subString) && Long.parseLong(subString) > 9) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isValidOneDigit(String subString) {
		return "0".equals(subString) ? false : true;
	}
}

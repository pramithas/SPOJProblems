import java.util.Scanner;

public class Aibohfobia {

	static int dp[][] = new int[6101][6101];

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		input.nextLine();
		int counter = 0;
		while (counter < testCases) {
			String inputString = input.nextLine();
			int subSequenceLength = compute(inputString, new StringBuilder(inputString).reverse().toString());
			System.out.println(inputString.length() - subSequenceLength);
			counter++;
		}
		input.close();
	}

	private static int compute(String s1, String s2) {
		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}

	private static int max(int i, int j) {
		return (i > j ? i : j);
	}
}
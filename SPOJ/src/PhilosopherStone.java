import java.util.Scanner;

public class PhilosopherStone {
	static int dp[][] = new int[101][101];
	static int row;
	static int column;

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		int counter = 0;
		while (counter < testCases) {
			row = input.nextInt();
			column = input.nextInt();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					dp[i][j] = input.nextInt();
				}
			}
			compute();
			System.out.println(findHighest());
			reset();
			counter++;
		}
		input.close();
	}

	private static void reset() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				dp[i][j] = 0;
			}
		}
		row = 0;
		column = 0;
	}

	private static int findHighest() {
		int max = dp[0][0];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (max < dp[i][j]) {
					max = dp[i][j];
				}
			}
		}
		return max;
	}

	private static void compute() {
		for (int i = row; i > 1; i--) {
			for (int j = 0; j < column; j++) {
				if (j == 0) {
					dp[i - 2][j] = (dp[i - 1][j] + dp[i - 2][j]) > (dp[i - 1][j + 1] + dp[i - 2][j])
							? (dp[i - 1][j] + dp[i - 2][j]) : (dp[i - 1][j + 1] + dp[i - 2][j]);
				} else if (j == column - 1) {
					dp[i - 2][j] = (dp[i - 1][j] + dp[i - 2][j]) > (dp[i - 1][j - 1] + dp[i - 2][j])
							? (dp[i - 1][j] + dp[i - 2][j]) : (dp[i - 1][j - 1] + dp[i - 2][j]);
				} else {
					dp[i - 2][j] = max(dp[i - 1][j] + dp[i - 2][j], dp[i - 1][j - 1] + dp[i - 2][j],
							dp[i - 1][j + 1] + dp[i - 2][j]);
				}
			}
		}
	}

	private static int max(int i, int j, int k) {
		if (i > j && i > k) {
			return i;
		} else if (j > k) {
			return j;
		} else {
			return k;
		}
	}
}

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 */

/**
 * @author Pramithas Dhakal
 *
 */
public class ANARC09ASeinfeld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		int counter = 0;
		Stack<Character> s = new Stack<Character>();
		while (!inputString.contains("-")) {
			for (int i = 0; i < inputString.length(); i++) {
				char c = inputString.charAt(i);
				if (c == '{') {
					s.push(c);
				} else if ((s.empty() || s.peek() == '}') && c == '}') {
					s.push(c);
				} else if (!s.empty()) {
					s.pop();
				}
			}
			System.out.println(++counter + ". " + s.size());
			s.clear();
			inputString = input.nextLine();
		}
		input.close();
	}
}

/**
 *
 */
package assignmentCheckerAlgorithm;

import java.util.*;
import java.lang.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class longestCommonSubsequence {

	/**
	 * @param args
	 */

	private static double copy;
	private static long match_Calculation_Dp[][];

	protected static double copyCalculation(List<String> motherList, List<String> childList) {

		int motherSize = motherList.size();
		int childSize = childList.size();
		match_Calculation_Dp = new long[childSize + 5][motherSize + 5];
		for (int i = 0; i <= motherSize + 2; i++) {
			match_Calculation_Dp[0][i] = 0;
		}
		for (int i = 0; i <= childSize + 2; i++) {
			match_Calculation_Dp[i][0] = 0;
		}

		for (int i = 1; i <= childSize; i++) {
			for (int j = 1; j <= motherSize; j++) {
				if (motherList.get(j - 1).equals(childList.get(i - 1))) {
					match_Calculation_Dp[i][j] = 1 + match_Calculation_Dp[i - 1][j - 1];
				} else {
					match_Calculation_Dp[i][j] = Math.max(match_Calculation_Dp[i][j - 1],
							match_Calculation_Dp[i - 1][j]);
				}
			}
		}
		/*
		 * copy Calculation
		 */
		copy = Math.floor(((match_Calculation_Dp[childSize][motherSize] * 1.0) / (motherSize * 1.0)) * 100.0);
		return copy;
	}

	public static void main(String[] args) {

		List<String> motherList = new ArrayList<String>();
		List<String> childList = new ArrayList<String>();
		Scanner scanner = fileFactory.scanner();
		int size = scanner.nextInt();
		motherList.clear();
		childList.clear();
		for (int i = 0; i < size; i++) {
			String str = scanner.next();
			motherList.add(str);
			// childList.add(str);
		}
		childList.add("liton");
		childList.add("babo");
		childList.add("kabir");
		System.out.println(longestCommonSubsequence.copyCalculation(childList,motherList));

	}

}

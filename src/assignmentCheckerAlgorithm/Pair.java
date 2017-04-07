/**
 * 
 */
package assignmentCheckerAlgorithm;

/**
 * @author Saif_sust_2013331007
 *
 */
public class Pair {

	Pair(String regNum, int solves) {
		this.regNum = regNum;
		this.solves = solves;
	}

	public int getSolves() {
		return solves;
	}

	public void setSolves(int solves) {
		this.solves = solves;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	@Override
	public String toString() {
		return "Pair [solves=" + solves + ", regNum=" + regNum + "]";
	}

	private int solves;
	private String regNum;
}

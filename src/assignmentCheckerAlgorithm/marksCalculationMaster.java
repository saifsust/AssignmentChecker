package assignmentCheckerAlgorithm;

public class marksCalculationMaster {

	public static double calculation(double copy, double min_copy, int solved, int totalProblems, double marks) {
		double deserved_marks = (double) (marks / (totalProblems * 1.0)) * (solved * 1.0);
		double cut_marks = (double) (deserved_marks / 100.0) * (copy - min_copy);
		//System.out.println(cut_marks);
		if (cut_marks < 0) {
			cut_marks = 0;
		}
		double deserved = Math.ceil(deserved_marks - cut_marks);
		return deserved;
	}

	public static void main(String[] args) {
		System.out.println(marksCalculationMaster.calculation(100, 100, 8, 10, 20));
	}
}

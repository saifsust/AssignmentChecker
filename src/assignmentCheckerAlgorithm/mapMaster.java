/**
 *
 */
package assignmentCheckerAlgorithm;

import java.io.*;
import java.lang.*;
import java.util.*;

import javax.print.DocFlavor.STRING;

/**
 * @author Saif_sust_2013331007
 *
 */
public class mapMaster {

	/**
	 * @param args
	 */
	private mapMaster() {
		student_Solve_Counter_List = new ArrayList<Pair>();
		students_Reg_To_solution_Map = new HashMap<String, Map<String, List<String>>>();
		codeSolutionMap = new HashMap<String, List<String>>();
		IsSame = new HashMap<String, Boolean>();
		RegNumList = new ArrayList<String>();
		solutionList = new ArrayList<String>();
		codeList = new ArrayList<String>();
		RegNums = new ArrayList<File>();
		students_Reg_To_solution_Map.clear();
		codeSolutionMap.clear();
		RegNumList.clear();
		solutionList.clear();
	}

	private void Map_Reg_To_Solution(String SelectedFolderPath) {
		RegNums.clear();
		RegNums = RegNumReaderMaster.RegNum(SelectedFolderPath);
		RegNumList.clear();
		IsSame.clear();
		solutionList.clear();
		student_Solve_Counter_List.clear();
		for (int i = 0; i < RegNums.size(); i++) {
			RegNum = RegNums.get(i);
			RegNumList.add(RegNum.getName());
			solutions = solutionReaderMaster.solutions(Path.getPath(RegNum));
			student_Solve_Counter_List.add(new Pair(RegNum.getName(), solutions.size()));
			codeSolutionMap.clear();
			for (int j = 0; j < solutions.size(); j++) {
				solution = null;
				solution = solutions.get(j);
				if (IsSame.get(solution.getName()) == null) {
					IsSame.put(solution.getName(), true);
					solutionList.add(solution.getName());
				}
				codeList.clear();
				ReaderMachine.clear();
				codeList = ReaderMachine.getCode(Path.getPath(solution));
				if (codeList.isEmpty()) {
					codeSolutionMap.put(solution.getName(),null);
				} else {
					codeSolutionMap.put(solution.getName(), new ArrayList<String>(codeList));
					ReaderMachine.clear();
				}
			}
			students_Reg_To_solution_Map.put(RegNum.getName(), new HashMap<String, List<String>>(codeSolutionMap));
		}

	}

	public static Map<String, Map<String, List<String>>> getMapper(String SelectedFolderPath) {
		Instance.Map_Reg_To_Solution(SelectedFolderPath);
		return Instance.students_Reg_To_solution_Map;
	}

	public static List<String> getAllRegNums() {
		return Instance.RegNumList;
	}

	public static List<String> getAllSolutions() {
		return Instance.solutionList;
	}

	public static void clear() {
		Instance.students_Reg_To_solution_Map.clear();
		Instance.codeSolutionMap.clear();
		Instance.codeList.clear();
		Instance.RegNums.clear();
		Instance.solutions.clear();
		Instance.RegNumList.clear();
		Instance.solutionList.clear();
		ReaderMachine.clear();
		RegNumReaderMaster.clear();
		solutionReaderMaster.clear();
	}

	public static List<Pair> getStudentSolvesInfo() {
		return student_Solve_Counter_List;
	}

	private Map<String, Map<String, List<String>>> students_Reg_To_solution_Map;
	private static mapMaster Instance = new mapMaster();
	private List<String> codeList;
	private Map<String, List<String>> codeSolutionMap;
	private List<File> RegNums, solutions;
	private File RegNum, solution;
	private List<String> RegNumList;
	private List<String> solutionList;
	private Map<String, Boolean> IsSame;
	private static List<Pair> student_Solve_Counter_List;

	public static void main(String[] args) {
		Map<String, Map<String, List<String>>> map = getMapper("dataStore");
		String reg = "", ques = "";
		for (int i = 0; i < getAllRegNums().size(); i++) {
			reg = "";
			reg = getAllRegNums().get(i);
			for (int j = 0; j < getAllSolutions().size(); j++) {
				ques = "";
				ques = getAllSolutions().get(j);
				if (ques.equals("") || map.get(reg) == null || map.get(reg).get(ques) == null)
					continue;
				System.out.println(reg + " " + ques);
				for (int k = 0; k < map.get(reg).get(ques).size(); k++) {

					System.out.println(map.get(reg).get(ques).get(k));
				}
			}
		}
		for (int i = 0; i < student_Solve_Counter_List.size(); i++) {
			System.out.println(student_Solve_Counter_List.get(i));
		}
		clear();
	}

}

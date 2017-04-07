/**
 * 
 */
package assignmentCheckerAlgorithm;

import java.util.*;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.lang.*;

/**
 * @author Saif_sust_2013331007
 *
 */
public class CalculationMaster {

	private CalculationMaster() {
		sumOfCopy = new HashMap<String, Double>();
		information = FXCollections.observableArrayList();
	}

	/**
	 * @param args
	 */

	public static ObservableList<studentData> getObservableList(String path, double min_copy, int totalProblems,
			int marks) {
		instance.calucation(path);
		instance.store_copy_Into_ObservableList(min_copy, totalProblems, marks);
		return instance.information;
	}

	private void store_copy_Into_ObservableList(double min_copy, int totalProblems, int marks) {
		information.clear();
		solves = mapMaster.getStudentSolvesInfo();
		for (int i = 0; i < solves.size(); i++) {
			// System.out.println(solves.get(i));
			double copy = (double) sumOfCopy.get(solves.get(i).getRegNum()) / solves.get(i).getSolves() * 1.0;
			int solved = solves.get(i).getSolves();
			String RegNum = solves.get(i).getRegNum();
			// System.out.println(copy);
			double mark = marksCalculationMaster.calculation(copy, min_copy, solved, totalProblems, marks);
			information.add(new studentData(RegNum, mark, copy, solved));

		}
	}

	private void calucation(String path) {
		students = mapMaster.getMapper(path);
		RegNum = mapMaster.getAllRegNums();
		Questions = mapMaster.getAllSolutions();
		String childReg = "", motherReg = "", question = "";
		sumOfCopy.clear();
		for (int reg = 0; reg < RegNum.size(); reg++) {
			sumOfCopy.put(RegNum.get(reg), 0.0);
		}
		double maxC = 0.0;
		for (int child = 0; child < RegNum.size(); child++) {
			childReg = "";
			childReg = RegNum.get(child);
			for (int quest = 0; quest < Questions.size(); quest++) {
				question = "";
				question = Questions.get(quest);

				if (students.get(childReg) == null || students.get(childReg).get(question) == null) {
					continue;
				} else {
					childList = students.get(childReg).get(question);
					maxC = 0.0;
					for (int mother = 0; mother < RegNum.size(); mother++) {
						if (mother == child)
							continue;
						motherReg = "";
						motherReg = RegNum.get(mother);
						if (students.get(motherReg) == null || students.get(motherReg).get(question) == null) {
							continue;
						} else {
							motherList = students.get(motherReg).get(question);
							double childCopy = longestCommonSubsequence.copyCalculation(childList, motherList);
							if (maxC < childCopy) {
								maxC = childCopy;
							}
							// System.out.println(question + " " + childReg + "
							// " + childCopy + " " + motherReg);
						}

					}
					double tempC = sumOfCopy.get(childReg);
					tempC += maxC;
					sumOfCopy.put(childReg, tempC);

				}

			}

		}

	}

	public static void clear() {
		instance.RegNum.clear();
		instance.Questions.clear();
		instance.childList.clear();
		mapMaster.clear();
		//instance.information.clear();
		instance.sumOfCopy.clear();
		instance.solves.clear();
	}

	private Map<String, Map<String, List<String>>> students;
	private List<String> RegNum, childList, motherList;
	private List<String> Questions;
	private ObservableList<studentData> information;
	private static CalculationMaster instance = new CalculationMaster();
	private Map<String, Double> sumOfCopy;
	private List<Pair> solves;

	public static void main(String[] args) {
		/*
		 * instance.calucation("dataStore"); for (int i = 0; i <
		 * instance.RegNum.size(); i++) {
		 * System.out.print(instance.RegNum.get(i) + "  ");
		 * System.out.println(instance.sumOfCopy.get(instance.RegNum.get(i))); }
		 * instance.store_copy_Into_ObservableList(0, 5, 20);
		 */
		instance.information = getObservableList("dataStore",0.0, 5, 20);
		for (int i = 0; i < instance.information.size(); i++) {
			System.out.println(instance.information.get(i).getCopy() + " " + instance.information.get(i).getMarks());
		}
		clear();
	}

}

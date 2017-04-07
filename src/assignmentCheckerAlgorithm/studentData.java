/**
 * 
 */
package assignmentCheckerAlgorithm;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Saif_sust_2013331007
 *
 */
public class studentData {

	public studentData(String RegNum, Double marks, Double copy, Integer solved) {
		this.regNum.setValue(RegNum);
		this.marks.setValue(marks);
		this.copy.setValue(copy);
		this.solved.setValue(solved);
	}

	public Double getMarks() {
		return marks.getValue();
	}

	public void setMarks(Double marks) {
		this.marks.setValue(marks);
	}

	public Integer getSolved() {
		return solved.getValue();
	}

	public void setSolved(Integer solved) {
		this.solved.setValue(solved);
	}

	public String getRegNum() {
		return regNum.getValue();
	}

	public void setRegNum(String regNum) {
		this.regNum.setValue(regNum);
	}

	public Double getCopy() {
		return copy.getValue();
	}

	public void setCopy(Double copy) {
		this.copy.setValue(copy);
	}

	@Override
	public String toString() {
		return "studentData [marks=" + marks + ", solved=" + solved + ", regNum=" + regNum + ", copy=" + copy + "]";
	}

	private DoubleProperty marks = new SimpleDoubleProperty();
	private IntegerProperty solved = new SimpleIntegerProperty();
	private StringProperty regNum = new SimpleStringProperty();
	private DoubleProperty copy = new SimpleDoubleProperty();
}

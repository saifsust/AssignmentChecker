package Design;

import assignmentCheckerAlgorithm.studentData;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class tableFactory implements constant {

	public static TableView<studentData> getMainTable(ObservableList<studentData> list) {

		setReg_numberColumn();
		setCopyColumn();
		setSolvesColumn();
		setMarksColumn();
		mainTable.getColumns().addAll(Reg_number, marks, copy, solves);
		mainTable.setItems(list);
		return mainTable;
	}

	private static void setMarksColumn() {
		marks.setCellValueFactory(new PropertyValueFactory<studentData, Double>("marks"));
		marks.setPrefWidth(tableColumnPrefWidth);
		marks.setResizable(false);
		// marks.setStyle("-fx-background-color: YELLOW;");

	}

	private static void setSolvesColumn() {
		solves.setCellValueFactory(new PropertyValueFactory<studentData, Integer>("solved"));
		solves.setPrefWidth(tableColumnPrefWidth);
		solves.setResizable(false);
		// solves.setStyle("-fx-background-color: YELLOW;");

	}

	private static void setCopyColumn() {
		copy.setCellValueFactory(new PropertyValueFactory<studentData, Double>("copy"));
		copy.setPrefWidth(tableColumnPrefWidth);
		copy.setResizable(false);
		// copy.setStyle("-fx-background-color: RED;");

	}

	private static void setReg_numberColumn() {
		Reg_number.setCellValueFactory(new PropertyValueFactory<studentData, String>("regNum"));
		Reg_number.setPrefWidth(tableRegPrefWidth);
		Reg_number.setResizable(false);
		// Reg_number.setStyle("-fx-background-color: GREEN;");

	}

	private static TableColumn<studentData, Double> copy = new TableColumn<studentData, Double>("Copy");
	private static TableColumn<studentData, Integer> solves = new TableColumn<studentData, Integer>("Solves");
	private static TableColumn<studentData, String> Reg_number = new TableColumn<studentData, String>("Reg_number");
	private static TableColumn<studentData, Double> marks = new TableColumn<studentData, Double>("Marks");
	private static TableView<studentData> mainTable = new TableView<studentData>();
	private static TableView<studentData> copyTable = new TableView<studentData>();

}

package luancher;

import java.io.File;

import Design.mainFrame;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		//new mainFrame(primaryStage);
		new mainFrame().init(primaryStage);

	}

	/*
	 *
	 */
	public static void main(String[] args) {


		//System.out.println(stringProcessor.ignorDot("liton.djfhdj"));


		//  getFactory.getObservableListOfInformations("dataStore");


		//cheatChecker cc = new cheatChecker();
		//cc.Processor();
		/*
		for(int i=0;i<getFactory.getObservableListOfInformations("dataStore").size();i++)
		{
			System.out.println(getFactory.getObservableListOfInformations("dataStore").get(i));
		}*/
		 launch(args);
	}
}

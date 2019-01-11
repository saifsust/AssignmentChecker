package org.app;

import java.io.File;

import org.apache.poi.util.SystemOutLogger;
import org.assignmentchecker.design.AppMainFrame;
import org.assignmentchecker.models.StudentData;

import javafx.application.Application;
import javafx.stage.Stage;


public class AppLauncher extends Application {
	@Override
	public void start(Stage primaryStage) {
		//new mainFrame(primaryStage);
		new AppMainFrame().init(primaryStage);

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

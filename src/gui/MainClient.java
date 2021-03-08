package gui;
	
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class MainClient extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TimeUnit.SECONDS.sleep(1);
		Parent root = FXMLLoader.load(getClass().getResource("Client_Employee.fxml"));
		primaryStage.setScene(new Scene(root,895,661));
		primaryStage.setTitle("MyFuel");
		root.getStylesheets().add("Employee.css");
		primaryStage.show();
		
	}
	
	
	public static void main(String[] args) {	
		launch(args);
	}
}

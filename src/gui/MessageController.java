package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;


public class MessageController extends Application {
	
	Stage window;
	@FXML private Label label = new Label();
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Message.fxml"));
		primaryStage.setScene(new Scene(root,460,100));
		primaryStage.setTitle("Message");
		label.setText("Please dont forget to disconnect from server!!!");
		primaryStage.show();
	}
	
	
	public void buttonPressed(ActionEvent event) {		
		Platform.exit();		
	}
	
	public static void main(String[] args) {	
		launch(args);
	}
}


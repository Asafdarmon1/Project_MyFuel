package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.RequestController_Client;



public class Client_Controller implements Initializable{

	public Connection conn;
	@FXML private TextArea printArea;
	@FXML private Label changeLabel;
	@FXML private Button updateOk = new Button();
	@FXML private TextField id;
	@FXML private TextField job;
	public static final int DEFAULT_PORT = 5555;
	private RequestController_Client client_logic;
	private MessageController msg = new MessageController();
	@Override
	public void initialize(URL location, ResourceBundle resources) {

			
			id.setVisible(false);
			job.setVisible(false);
			updateOk.setVisible(false);
			changeLabel.setVisible(false);
			printArea.setVisible(true);
	}
	
	//print employees
	public void printPressed() throws Exception{ //handle with the "print employee" press

		id.setVisible(false);
		job.setVisible(false);
		updateOk.setVisible(false);
		changeLabel.setVisible(false);
		printArea.setVisible(true);
		
		try {
		this.client_logic = new RequestController_Client("localhost",this,5555);//"this" for using EmployeeController function		
		this.client_logic.handlePress("print"); //knowing that the user want to print, jump to "RequestController_Client" class
		}catch(IOException e) {
			e.printStackTrace();			
		}

	}

	
	//update employees
	public void updatePressed(ActionEvent event){ //handle with the "print employee" press


		id.setVisible(true);
		job.setVisible(true);
		id.setText("");
		job.setText("");
		changeLabel.setVisible(true);
		updateOk.setVisible(true);
	}
	
	public void updateEmployee(ActionEvent event) throws IOException {
		

		List<String> update = new ArrayList<String>();
		update.add(id.getText());
		update.add(job.getText());
		this.client_logic = new RequestController_Client("localhost",this,5555);//"this" for using EmployeeController function		
		this.client_logic.handlePress(update); //knowing that the user want to print, jump to "RequestController_Client" class
		update = new ArrayList<String>();
		
		
	}
	public void printEmployee(String query) {
 		this.printArea.setText(query);
	}

	public void updatePrint(String message) throws Exception {

			printArea.setText(message);
		}

	public void closeOption(ActionEvent event) throws InterruptedException
	{		
		Stage windowStage = new Stage();
		try {
			msg.start(windowStage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

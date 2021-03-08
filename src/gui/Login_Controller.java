package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login_Controller extends Application implements Initializable{

	@FXML private Button userCreateAccount = new Button();
	@FXML private TextField userName;
	@FXML private PasswordField userPassword;
	@FXML private AnchorPane pane = new AnchorPane();
	@FXML private ImageView img = new ImageView();
	@FXML private Button agentLogin = new Button();
	@FXML private TextField agentName;
	@FXML private PasswordField agentPassword;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		final Tooltip userNameTooltip = new Tooltip();
		final Tooltip userPasswordTooltip = new Tooltip();
		userNameTooltip.setText("Please enter user name");
		userPasswordTooltip.setText("Please enter password");	
		userName.setTooltip(userNameTooltip);
		userPassword.setTooltip(userPasswordTooltip);
		final Tooltip agentNameTooltip = new Tooltip();
		final Tooltip agentPasswordTooltip = new Tooltip();
		agentNameTooltip.setText("Please enter agent name");
		agentPasswordTooltip.setText("Please enter agent password");
		agentName.setTooltip(agentNameTooltip);
		agentPassword.setTooltip(agentPasswordTooltip);


	}
	

	public void start(Stage primaryStage) throws Exception {
		
	    // load the image
		Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		primaryStage.setScene(new Scene(root,900,600));
		primaryStage.setTitle("Welcome To MyFuel");
		root.getStylesheets().add("Buttons.css");
		primaryStage.show();		
	}
	
	
	public void createAccountPressed() {
		
		pane.setVisible(true);
		img.setVisible(true);		
	}
	
	public void agentLoginPressed(ActionEvent event) throws IOException {
		
		Parent createAccountParent = FXMLLoader.load(getClass().getResource("MarketingAgentPage.fxml"));
		//For Getting Information From Stage
		Stage windowStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		windowStage.setScene(new Scene(createAccountParent,885,593));
		windowStage.setTitle("Markerting Page");
		windowStage.show();
		
	}
	public static void main(String args[]) {		
		launch();		
	}

}

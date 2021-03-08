package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

public class ClientRegister_Controller implements Initializable{

	//add clients fields
	@FXML private TextField clientUserName;	
	@FXML private PasswordField clientPassword;
	@FXML private TextField clientFirstName;
	@FXML private TextField clientLastName;	
	@FXML private TextField clientId;
	@FXML private TextField clientEmail;
	@FXML private TextField clientCreditNumber;
	@FXML private AnchorPane pane1 = new AnchorPane();
	//choose client plan
	@FXML private ChoiceBox<String> clientType = new ChoiceBox<String>();
	@FXML private AnchorPane pane2 = new AnchorPane();
	//adjust fields
	@FXML private AnchorPane adjustPane = new AnchorPane();
	@FXML private TextField adjustClientId = new TextField();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		adjustPane.setVisible(false);
		pane1.setVisible(false);
		pane2.setVisible(false);
		clientType.setValue("Please choose client type..");
		clientType.getItems().add("Private Client");
		clientType.getItems().add("Company Client");
		//Floating textField
		final Tooltip clientUserNameTooltip = new Tooltip();
		final Tooltip clientPasswordTooltip = new Tooltip();
		clientUserNameTooltip.setText("Please enter client username");
		clientPasswordTooltip.setText("Please enter client password");	
		clientUserName.setTooltip(clientUserNameTooltip);
		clientPassword.setTooltip(clientPasswordTooltip);
		
		final Tooltip clientFirstNameTooltip = new Tooltip();
		final Tooltip clientLastNameTooltip = new Tooltip();
		clientFirstNameTooltip.setText("Please enter client first name");
		clientLastNameTooltip.setText("Please enter client last name");	
		clientFirstName.setTooltip(clientFirstNameTooltip);
		clientLastName.setTooltip(clientLastNameTooltip);
		
		final Tooltip clientIdTooltip = new Tooltip();
		final Tooltip clientEmailTooltip = new Tooltip();
		clientIdTooltip.setText("Please enter client id");
		clientEmailTooltip.setText("Please enter client email");
		clientId.setTooltip(clientIdTooltip);
		clientEmail.setTooltip(clientEmailTooltip);
		
		final Tooltip clientCreditCardTooltip = new Tooltip();
		clientCreditCardTooltip.setText("Please enter client credit card number");
		clientCreditNumber.setTooltip(clientCreditCardTooltip);
		
		final Tooltip adjustClientIdTooltip = new Tooltip();
		adjustClientIdTooltip.setText("Please enter client Id");
		adjustClientId.setTooltip(clientCreditCardTooltip);
	}
	
	
	public void addClientPressed() {	
		adjustPane.setVisible(false);
		pane1.setVisible(true);
				
	}
	
	public void nextPressed() {	
		adjustPane.setVisible(false);
		pane2.setVisible(true);
	}
	
	public void adjustPlanPressed() {
		
		adjustPane.setVisible(true);
		pane1.setVisible(false);
		pane2.setVisible(false);
	}
	
}

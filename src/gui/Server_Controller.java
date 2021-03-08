package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import logic.RequestController_Server;



public class Server_Controller
{

	Stage primaryStage;
  @FXML
  public TextArea server_log_textArea;

  @FXML
  private Button connectButton;

  @FXML
  private Button stopServerButton;
  private RequestController_Server sv;

  @FXML
  void connectPressed(ActionEvent event) 
  {
    int port = 0;
    port = 5555;
    this.sv = new RequestController_Server(port);
    try
    {
      this.sv.listen();
      this.server_log_textArea.setText("Server is listening on port: " + port + "\n" + "Please start client.");
    }
    catch (Exception ex)
    {
      this.server_log_textArea.setText("ERROR - Could not listen for clients!");
      System.out.println("ERROR - Could not listen for clients!");
      return;
    }
   
  }

  @FXML
  void stopPressed() throws Exception
  {
	
    this.sv.close();
    this.server_log_textArea.setText("Server has stopped listening and closed the port.");
  }
}
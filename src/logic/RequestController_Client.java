package logic;

import java.io.IOException;

import gui.Client_Controller;
import ocsf.client.AbstractClient;

public class RequestController_Client extends AbstractClient {
	
	
	  Client_Controller emp;

	public RequestController_Client(String host,Client_Controller emp, int port) throws IOException {
		super(host, port);
		this.emp = emp; //to use for print
		openConnection(); //open connection for the server
	}

	
	
	  public void handlePress(Object message) //handle the actual "print" press on the gui (fxml attached)
	  {
	    try {
	      sendToServer(message); //in that case, sending to the server the word "print"
	    }
	    catch (IOException e)
	    {
	      System.out.println("Could not send message to server.  Terminating client.");
	      quit();
	    }
	  }
	
	@Override
	protected void handleMessageFromServer(Object msg) { //first method that runs from "SendToClient"

		if(msg instanceof String) {
		try {
			emp.printEmployee((String)msg); //setting the information using the gui
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	else {
		if((boolean)msg.equals(false)) {
			try {
				emp.updatePrint("Error has occured");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				emp.updatePrint("Update success, print to see changes.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
		
	}
	  public void quit()
	  {
	    try {
	      closeConnection();
	    } catch (IOException localIOException) {
	    }
	    System.exit(0);
	  }
	
}

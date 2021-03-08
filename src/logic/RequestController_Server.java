package logic;

import java.util.ArrayList;
import java.util.List;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class RequestController_Server extends AbstractServer {
	
	private SqlConnection sql;	  
	protected List<String> a = new ArrayList<String>();
	protected List<String> b = new ArrayList<String>();
	
	public RequestController_Server(int port) {
	super(port);
		sql = new SqlConnection();
		
	}


	final public static int DEFAULT_PORT = 5555;
	
	
  public static void main(String[] args) 
	  {
	    int port = 0; //Port to listen on

	    try
	    {
	      port = Integer.parseInt(args[0]); //Get port from command line
	    }
	    catch(Throwable t)
	    {
	      port = DEFAULT_PORT; //Set port to 5555
	    }
		
	    RequestController_Server sv = new RequestController_Server(port);
	    
	    try 
	    {
	      sv.listen(); //Start listening for connections
	    } 
	    catch (Exception ex) 
	    {
	      System.out.println("ERROR - Could not listen for clients!");
	    }
	  }

@SuppressWarnings("unchecked")
@Override
protected void handleMessageFromClient(Object msg, ConnectionToClient client) { //first method that running from "SendToServer"
	
	String query;

    if ((msg.equals("print"))) {
        try {        	
        	query = sql.printRequest(); //jumping to "SqlConnection" class for getting information from db
        	client.sendToClient(query); //sending back the information to the client (RequestController_Client)
        } catch (Exception e) {
          e.printStackTrace();
        }
    } 
      else
        try
        {
        	b = (List<String>)(msg);
        	a = sql.checkRequest(b.get(0).toString());
          if(a.contains("request not found"))
        	  client.sendToClient(false);
          else {
        	  query = sql.updateRequest(b);
        	  if(query.contains("success"))
        		  client.sendToClient(true);
        	  else
            	  client.sendToClient(false);
          }
         
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
	
	
	
	
}
	

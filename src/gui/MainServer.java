package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainServer extends Application
{
  public void start(Stage primaryStage)
  {
    try
    {
		
		Parent root = FXMLLoader.load(getClass().getResource("Server.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Connect to server");
		root.getStylesheets().add("Server.css");
		primaryStage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
      return;
    }
  }

  public static void main(String[] args)
  {
    launch(args);
  }
}
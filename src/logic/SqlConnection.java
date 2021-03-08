package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlConnection {
	
	private Connection con;
	private boolean dbConnected = false;
    List<String> list = new ArrayList<String>();
	public SqlConnection() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/MyFuel?serverTimezone=IST","root","root");	
			dbConnected = true;
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		
	}
	
	
public String printRequest()
	  {
	    //if (!this.dbConnected) return null;

		Statement stmt;
		String query = "";		
		try {
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee;");
 		while(rs.next())
 		{
			 // Print out the values
 			query +="Full Name:  " + rs.getString(1) + " "+ rs.getString(2) + "\n"
			 + "Employee Id:  " +  rs.getString(3) + "\n"
 					+ "Email:  " + rs.getString(4) + "\n"
			 + "Job:  " + rs.getString(5) + "\n" + "Organization: " + " " + rs.getString(6) + "\n";
 			query += "\n";
		}
		rs.close();
		return query;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
		
	}

		
	  }



public List<String> checkRequest(String id) throws Exception {

	    if (!this.dbConnected) return null;
	    list = new ArrayList<String>();
	    try
	    {
	      PreparedStatement stmt = this.con.prepareStatement("SELECT * from employee E where E.E_Id = ?");
	      stmt.setString(1, id);
	      ResultSet rs = stmt.executeQuery();
	      if (rs.next())
	      {
	        list.add(rs.getString(1));
	        list.add(rs.getString(2));
	        list.add(rs.getString(3));
	        list.add(rs.getString(4));
	        list.add(rs.getString(5));
	        list.add(rs.getString(6));
	      }
	      else
	      {
	        list.add("request not found");
	      }
	      rs.close();
	    }
	    catch (SQLException ex)
	    {
	      System.out.println(ex);
	    }

	    return list;
	  }


public String updateRequest(List<String> b) throws Exception{
	
	PreparedStatement preparedStmt;		
		try {
		preparedStmt = con.prepareStatement("UPDATE employee SET Job = ? WHERE E_Id = ?");
		preparedStmt.setString(1, b.get(1).toString());
		preparedStmt.setString(2, b.get(0).toString());
	    preparedStmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			return "request not found";
		}
		return "success";
	}
}

package application;

import java.sql.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class SQLConnection {
	@FXML private Parent root;
	private String username;
	private String password;
		
		
	public SQLConnection(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SQLConnection [username=" + username + ", password=" + password + "]";
	}
	
	public boolean check_user() {
		boolean got_user = false;
	    Connection c = null;
	    Statement stmt = null;
	      
	    try {
	    	Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:proiect.db");
	        c.setAutoCommit(false);
	        System.out.println("Database opened!");
	         
	        stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "SELECT * FROM USERS;" );
	         
	        while (rs.next()) {
	        	int db_userid = rs.getInt("USER_ID");
	        	String db_username = rs.getString("USERNAME");
	        	String db_password = rs.getString("PASSWORD");
	        	
	        	if(username.equals(db_username) && password.equals(db_password)) {
	        		System.out.println("ID = " + db_userid);
	        		System.out.println("NAME = " + username );
	        		System.out.println("PASSWORD = " + password );
	        		System.out.println();
	        		
	        		FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
	    	    	root = loader.load();
	    	    	
	    	    	MainController maincontroller = loader.getController();
	    	    	maincontroller.login_id(db_userid);
	    	    	
	        		got_user = true;
	        		break;
	        	}
	        	else
	        		got_user = false;
	        }
	        rs.close();
	        stmt.close();
	        c.close();
	         
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	    
	    if(got_user)
	    	return true;
	    else
	    	System.out.println("No user found!");
	    	return false;
	}
	
	public boolean check_user2() {
		boolean got_user = false;
	    Connection c = null;
	    Statement stmt = null;
	      
	    try {
	    	Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:proiect.db");
	        c.setAutoCommit(false);
	        System.out.println("Database opened!");
	         
	        stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "SELECT * FROM USERS;" );
	         
	        while (rs.next()) {
	        	String db_username = rs.getString("USERNAME");
	        	
	        	if(username.equals(db_username)) {
	        		System.out.println("NAME = " + username );
	        		System.out.println();
	        		got_user = true;
	        		break;
	        	}
	        	else
	        		got_user = false;
	        }
	        rs.close();
	        stmt.close();
	        c.close();
	         
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	    
	    if(got_user)
	    	return true;
	    else
	    	System.out.println("No user found!");
	    	return false;
	}
	
	public boolean add_user() {
		boolean added_user = false;
		Connection c = null;
	    PreparedStatement stmt = null;
	      
	    try {
	    	Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:proiect.db");
	        System.out.println("Database opened!");
	        
	        try {
	        	stmt = c.prepareStatement("INSERT INTO USERS(USERNAME, PASSWORD) VALUES(?,?)");
	        	stmt.setString(1, username);
	        	stmt.setString(2, password);
	        	stmt.executeUpdate();
	        	System.out.println("Added");
	        	added_user = true;
	        }
	        catch(SQLException e) {
	            e.printStackTrace();
	        }
	        
	        stmt.close();
	        c.close();
	         
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	    
	    if(added_user)
	    	return true;
	    else
	    	System.out.println("User did not register!");
	    	return false;
	}
}

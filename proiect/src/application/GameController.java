package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameController {
	@FXML private Stage stage;
	@FXML private Label question;
	@FXML private Button answer1;
	@FXML private Button answer2;
	@FXML private Button answer3;
	@FXML private Button answer4;
	@FXML private Label question_id_label;
	
	//private int difficulty;
	
	
	public void set_question(int difficulty) {
		List<Integer> question_id = new ArrayList<>();
		Connection c = null;
	    PreparedStatement pstmt = null;
	    Random rand = new Random();
	    
	    try {
	    	Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:proiect.db");
	        c.setAutoCommit(false);
	        System.out.println("Database opened!");
	         
	        pstmt = c.prepareStatement( "SELECT * FROM QUESTIONS WHERE DIFFICULTY = ?" );
	        pstmt.setInt(1, difficulty);
	        ResultSet rs = pstmt.executeQuery();
	         
	        while (rs.next()) {
	        	int db_qid = rs.getInt("QUESTION_ID");
	        	question_id.add(db_qid);
	        }
	        rs.close();
	        int set_id = question_id.get(rand.nextInt(question_id.size()));
	        question_id_label.setText(Integer.toString(set_id));
	        pstmt = c.prepareStatement( "SELECT * FROM QUESTIONS WHERE QUESTION_ID = ?" );
	        pstmt.setInt(1, set_id);
	        rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	question.setText(rs.getString("QUESTION"));
	        	String[] answers = rs.getString("ANSWERS").split(",");
	        	answer1.setText(answers[0]);
	        	answer2.setText(answers[1]);
	        	answer3.setText(answers[2]);
	        	answer4.setText(answers[3]);
	        	
	        }
	        rs.close();
	        pstmt.close();
	        c.close();
	         
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	}
	
	public void answer1(ActionEvent event) throws Exception {
		Connection c = null;
	    PreparedStatement pstmt = null;
	    
		try {
	    	Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:proiect.db");
	        c.setAutoCommit(false);
	        System.out.println("Database opened!");
	        
	        String question_id = question_id_label.getText();
	        pstmt = c.prepareStatement( "SELECT ANSWER FROM QUESTIONS WHERE QUESTION_ID = ?" );
	        pstmt.setString(1, question_id);
	        ResultSet rs = pstmt.executeQuery();
	         
	        while (rs.next()) {
	        	String answer = answer1.getText();
	        	String correct_answer = rs.getString("ANSWER");
	        	System.out.println(answer);
	        	System.out.println(correct_answer);
	        	if(answer.equals(correct_answer)) {
	        		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	                stage.close();
	        	}
	        	else {
	        		System.out.println("Nup!");
	        	}
	        }
	        rs.close();
	        pstmt.close();
	        c.close();
	         
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	}
	
	public void answer2(ActionEvent event) throws Exception {
		Connection c = null;
	    PreparedStatement pstmt = null;
	    
		try {
	    	Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:proiect.db");
	        c.setAutoCommit(false);
	        System.out.println("Database opened!");
	        
	        String question_id = question_id_label.getText();
	        pstmt = c.prepareStatement( "SELECT ANSWER FROM QUESTIONS WHERE QUESTION_ID = ?" );
	        pstmt.setString(1, question_id);
	        ResultSet rs = pstmt.executeQuery();
	         
	        while (rs.next()) {
	        	String answer = answer2.getText();
	        	String correct_answer = rs.getString("ANSWER");
	        	System.out.println(answer);
	        	System.out.println(correct_answer);
	        	if(answer.equals(correct_answer)) {
	        		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	                stage.close();
	        	}
	        	else {
	        		System.out.println("Nup!");
	        	}
	        }
	        rs.close();
	        pstmt.close();
	        c.close();
	         
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	}
	
	public void answer3(ActionEvent event) throws Exception {
		Connection c = null;
	    PreparedStatement pstmt = null;
	    
		try {
	    	Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:proiect.db");
	        c.setAutoCommit(false);
	        System.out.println("Database opened!");
	        
	        String question_id = question_id_label.getText();
	        pstmt = c.prepareStatement( "SELECT ANSWER FROM QUESTIONS WHERE QUESTION_ID = ?" );
	        pstmt.setString(1, question_id);
	        ResultSet rs = pstmt.executeQuery();
	         
	        while (rs.next()) {
	        	String answer = answer3.getText();
	        	String correct_answer = rs.getString("ANSWER");
	        	System.out.println(answer);
	        	System.out.println(correct_answer);
	        	if(answer.equals(correct_answer)) {
	        		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	                stage.close();
	        	}
	        	else {
	        		System.out.println("Nup!");
	        	}
	        }
	        rs.close();
	        pstmt.close();
	        c.close();
	         
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	}
	
	public void answer4(ActionEvent event) throws Exception {
		Connection c = null;
	    PreparedStatement pstmt = null;
	    
		try {
	    	Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:proiect.db");
	        c.setAutoCommit(false);
	        System.out.println("Database opened!");
	        
	        String question_id = question_id_label.getText();
	        pstmt = c.prepareStatement( "SELECT ANSWER FROM QUESTIONS WHERE QUESTION_ID = ?" );
	        pstmt.setString(1, question_id);
	        ResultSet rs = pstmt.executeQuery();
	         
	        while (rs.next()) {
	        	String answer = answer4.getText();
	        	String correct_answer = rs.getString("ANSWER");
	        	System.out.println(answer);
	        	System.out.println(correct_answer);
	        	if(answer.equals(correct_answer)) {
	        		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	                stage.close();
	        	}
	        	else {
	        		System.out.println("Nup!");
	        	}
	        }
	        rs.close();
	        pstmt.close();
	        c.close();
	         
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	}
}

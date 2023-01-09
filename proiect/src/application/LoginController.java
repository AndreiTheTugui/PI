package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class LoginController{
	//Login/Register page
    @FXML private Stage stage;
    @FXML private Scene scene;
    @FXML private Parent root;
    @FXML private TextField user_field;
    @FXML private PasswordField passwrd_field;
    @FXML private PasswordField passwrd_field2;
    @FXML private Button login_btn;
    @FXML private Button login_btn2;
    @FXML private Label user_text;
    @FXML private Label invalid_login;
    @FXML private Label confirm_text;
    @FXML private Button register_btn;
    @FXML private Button register_btn2;
    @FXML private Button exit_btn;
    
    public void exit(ActionEvent event) throws Exception{
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    public void login_check(ActionEvent event) throws Exception{
    	String username = user_field.getText();
    	String password = passwrd_field.getText();
    	SQLConnection user = new SQLConnection(username, password);
    	System.out.println(user.toString());
    	if(!username.isEmpty() && !password.isEmpty()) {
    		if(user.check_user()) {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
    	    	root = loader.load();
    	    	
    	    	MainController maincontroller = loader.getController();
    	    	maincontroller.displayName(username);
    			
    	    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    			scene = new Scene(root);
    	    	stage.setScene(scene);
    	    	stage.show();
    		}
    		else {
    			invalid_login.setText("Invalid login");
    			invalid_login.setVisible(true);
    		}
    	}
    	else {
    		invalid_login.setText("Username or \npassword empty");
			invalid_login.setVisible(true);
    	}
    		
    }
    
    public void register_page(ActionEvent event) {
    	user_field.setText("");
    	passwrd_field.setText("");
    	passwrd_field2.setText("");
    	
    	login_btn.setVisible(false);
    	login_btn2.setVisible(true);
    	register_btn.setVisible(true);
    	register_btn2.setVisible(false);
    	user_text.setTextFill(Color.BLACK);
		confirm_text.setTextFill(Color.BLACK);
    	confirm_text.setVisible(true);
    	passwrd_field2.setVisible(true);
    	invalid_login.setVisible(false);
    }
    
    public void login_page2(ActionEvent event) {
    	user_field.setText("");
    	passwrd_field.setText("");
    	passwrd_field2.setText("");
    	
    	login_btn.setVisible(true);
    	login_btn2.setVisible(false);
    	register_btn.setVisible(false);
    	register_btn2.setVisible(true);
    	user_text.setTextFill(Color.BLACK);
		confirm_text.setTextFill(Color.BLACK);
    	confirm_text.setVisible(false);
    	passwrd_field2.setVisible(false);
    	invalid_login.setVisible(false);
    }
    
    public void register_check(ActionEvent event) {
    	String username = user_field.getText();
    	String password = passwrd_field.getText();
    	String confirm_password = passwrd_field2.getText();
    	SQLConnection user = new SQLConnection(username, password);
    	if(confirm_password.equals(password)) {
    		if(!user.check_user2() && !username.isEmpty() && !password.isEmpty()) {
    			if(user.add_user()) {
    				invalid_login.setText("Registered!");
    				invalid_login.setTextFill(Color.GREEN);
    				user_text.setTextFill(Color.BLACK);
    				confirm_text.setTextFill(Color.BLACK);
    				invalid_login.setVisible(true);
    			}
    			else {
    				invalid_login.setText("Invalid Register");
        			invalid_login.setTextFill(Color.RED);
            		user_text.setTextFill(Color.RED);
            		confirm_text.setTextFill(Color.RED);
            		invalid_login.setVisible(true);
    			}
    		}
    		else {
    			invalid_login.setText("Invalid Register");
    			invalid_login.setTextFill(Color.RED);
        		user_text.setTextFill(Color.RED);
        		confirm_text.setTextFill(Color.BLACK);
        		invalid_login.setVisible(true);
    		}		
    	}
    	else {
    		invalid_login.setText("Invalid Register");
    		invalid_login.setTextFill(Color.RED);
    		user_text.setTextFill(Color.BLACK);
    		confirm_text.setTextFill(Color.RED);
    		invalid_login.setVisible(true);
    	}
    }
}


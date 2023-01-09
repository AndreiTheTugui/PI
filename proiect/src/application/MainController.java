package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class MainController {
	//Main menu
	@FXML private Stage stage;
	@FXML private Scene scene;
	@FXML private Parent root;
	@FXML private Label logged_name;
	private int logged_userid = 0;
    
	public void login_id(int userid) {
		logged_userid = userid;
		System.out.println(logged_userid);
	}
	
	public void displayName(String username) {
		logged_name.setText(username);
	}
	
	public void game(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
    	root = loader.load();
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	GameController gamecontroller = loader.getController();
    	gamecontroller.set_question(1);
	}
	
    public void exit(ActionEvent event) throws Exception{
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    public void login_page(ActionEvent event) throws Exception{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
    	root = loader.load();
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	logged_name.setText("");
    	logged_userid = 0;
    }
}

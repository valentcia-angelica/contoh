package views;

import controller.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.User;

public class LoginView extends GridPane {

	Stage stage;
	TextField name, pass;
	Button loginBtn;
	
	private void init() {
		name = new TextField();
		pass = new TextField();
		loginBtn = new Button("Login");
		loginBtn.setOnAction(e -> {
			String username = name.getText();
			String password = pass.getText();
			User user = UserController.Login(username, password);
			if (user == null) {
				new RegisterView(stage);
			}
		});
	}
	
	private void setLayout() {
		this.add(name, 0, 0);
		this.add(pass, 0, 1);
		this.add(loginBtn, 0, 2);
	}

	public LoginView(Stage stage) {
		// TODO Auto-generated constructor stub
		this.stage = stage;
		init();
		setLayout();
		Scene scene = new Scene(this, 400, 200);
		stage.setScene(scene);
		stage.show();
	}

}

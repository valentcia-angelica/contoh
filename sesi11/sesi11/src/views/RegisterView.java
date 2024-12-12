package views;

import controller.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegisterView extends GridPane {
	
	Stage stage;
	TextField name, pass;
	Button registerBtn, goToLogin;
	
	private void init() {
		name = new TextField();
		pass = new TextField();
		registerBtn = new Button("Register");
		registerBtn.setOnAction(e -> {
			String username = name.getText();
			String password = pass.getText();
			boolean result = UserController.Register(username, password);
			
			if (result) {
				System.out.println("success");
			} else {
				System.out.println("failed");
			}
		});
		
		goToLogin = new Button("Sign In");
		goToLogin.setOnAction(e -> {
			new LoginView(stage);
		});
	}
	
	private void setLayout() {
		this.add(name, 0, 0);
		this.add(pass, 0, 1);
		this.add(registerBtn, 0, 2);
		this.add(goToLogin, 0, 3);
		
	}

	public RegisterView(Stage stage) {
		// TODO Auto-generated constructor stub
		this.stage = stage;
		init();
		setLayout();
		Scene scene = new Scene(this, 400, 200);
		stage.setScene(scene);
		stage.show();
	}

}

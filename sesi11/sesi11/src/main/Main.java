package main;

import javafx.application.Application;
import javafx.stage.Stage;
import views.RegisterView;

public class Main extends Application {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		new RegisterView(primaryStage);
	}
	
	
}
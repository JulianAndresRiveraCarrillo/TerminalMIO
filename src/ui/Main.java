package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	PrincipalController controller;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Principal.fxml"));
		
		fxml.setController(controller);
		
		Parent root = fxml.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("BIENVENIDO...!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

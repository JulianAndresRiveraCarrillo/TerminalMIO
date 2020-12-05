package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class AddController {

	//Add GUI
	@FXML
	private TextField nameTF;

	@FXML
	private TextField capacityTF;

	@FXML
	private TextField routeTF;
	 
	//Connect GUI
	@FXML
	private TextField firstTF;

	@FXML
	private TextField lastTF;
	
	//=========================================================
	
	@FXML
    void add(ActionEvent event) {
		String name = nameTF.getText();
		int capacity = Integer.parseInt(capacityTF.getText());
		String route = routeTF.getText();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Se ha agregado correctamente");
		alert.showAndWait();
    }

	@FXML
    void connect(ActionEvent event) {
		String first = firstTF.getText();
		String last = lastTF.getText();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Se han conectado correctamente");
		alert.setContentText(first + " conectado con " + last); 
		alert.showAndWait();
	}

	@FXML
	public void regresarVentana(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/principal_1.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}

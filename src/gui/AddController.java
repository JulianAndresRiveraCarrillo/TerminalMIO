package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
}

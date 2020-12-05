package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class DeleteController {

	@FXML
	private TextField nameTF;
	
	@FXML
	void delete(ActionEvent event) {
		String temp = nameTF.getText();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Se ha eliminado correctamente");
		alert.showAndWait();
	}
}

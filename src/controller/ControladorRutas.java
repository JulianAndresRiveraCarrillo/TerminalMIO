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

public class ControladorRutas {

	@FXML
    private TextField departureTF;

    @FXML
    private TextField arrivalTF;
    
    @FXML
    void route(ActionEvent event) {
    	String departure = departureTF.getText();
    	String arrival = arrivalTF.getText();
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("la ruta es:");
    	alert.setContentText("Ruta 1" + "\n" + "Ruta 2" + "\n"  + "Ruta 3");
    	alert.showAndWait();
    }
    
    @FXML
    void routeComplete(ActionEvent event) {
    	String departure = departureTF.getText();
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("la ruta es:");
    	alert.setContentText("Ruta 1" + "\n" + "Ruta 2" + "\n"  + "Ruta 3");
    	alert.showAndWait();
    }

	@FXML
	public void mostrarVentanaPrincipal(ActionEvent actionEvent) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/principal_1.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
	}
}

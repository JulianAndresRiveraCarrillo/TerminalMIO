package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RouteController {

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
    
    

}

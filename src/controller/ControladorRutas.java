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

import excepciones.EstacionNoEncontradaException;

public class ControladorRutas {

	@FXML
    private TextField departureTF;

    @FXML
    private TextField arrivalTF;
    
    @FXML
    void route(ActionEvent event) {
    	String departure = departureTF.getText();
    	String arrival = arrivalTF.getText();
    	try {
    		if(departure.length()!=0 && arrival.length()!=0) {
    			if (ControladorPrincipal_1.admin.buscar(departure) != null && ControladorPrincipal_1.admin.buscar(arrival) != null) {
    				String message = ControladorPrincipal_1.admin.rutaEntreDosEstaciones(departure, arrival);
    				if(message != null) {
	    				Alert alert = new Alert(AlertType.CONFIRMATION);
	    		    	alert.setHeaderText("la ruta encontrada es:");
	    		    	alert.setContentText(message);
	    		    	alert.showAndWait();
    				}
    			}else {
    				throw new EstacionNoEncontradaException();
    			}
    		}else {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setHeaderText("Verifica las entrada");
    			alert.setContentText("El campo de texto esta vacio");
    			alert.showAndWait();
    		}
    	}catch(EstacionNoEncontradaException en) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(en.getMessage());
			alert.showAndWait();
    	}
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

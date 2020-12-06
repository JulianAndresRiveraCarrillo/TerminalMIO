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

public class ControladorConectar {
	
	@FXML
	private TextField firstTF;

	@FXML
	private TextField lastTF;

	@FXML
	private TextField distanceTF;
	
	@FXML
    void connect(ActionEvent event) {
		String first = " ";
		String last = " ";
		int distance = 0;
		
		try {
			if ((firstTF.getText().length() == 0) && (lastTF.getText().length() == 0)) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Verifica las entradas");
				alert.setContentText("Los campos de texto estan vacios");
				alert.showAndWait();
			}else {
				first = firstTF.getText();
				last = lastTF.getText();
				distance = Integer.parseInt(distanceTF.getText());
			}
			
			if(ControladorPrincipal_1.admin.añadirConexion(first, last, distance) == false) {
				throw new EstacionNoEncontradaException();
			}
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Se han conectado correctamente");
			alert.setContentText(first.toUpperCase() + " conectado con " + last.toUpperCase()); 
			alert.showAndWait();
		} catch (NumberFormatException nf) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Verifica la distancia");
			alert.setContentText("Solo se permiten numeros enteros en el campo de texto");
			alert.showAndWait();
		} catch (EstacionNoEncontradaException en) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(en.getMessage());
			alert.showAndWait();
		}
	}
	
	@FXML
    void disconnect(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Se ha eliminado la estacion correctamente");
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

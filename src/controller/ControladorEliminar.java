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

public class ControladorEliminar {

	@FXML
	private TextField nameTF;
	
	@FXML
	void delete(ActionEvent event) {
		String temp = nameTF.getText();
		
		try {
			if (temp.length() != 0) {
				if (ControladorPrincipal_1.admin.eliminarEstacion(temp) == false) {
					throw new EstacionNoEncontradaException();
				}
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Verifica la entrada");
				alert.setContentText("El campo de texto vacio");
				alert.showAndWait();
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Se ha eliminado correctamente");
			alert.showAndWait();
		} catch (EstacionNoEncontradaException en) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(en.getMessage());
			alert.showAndWait();
		}
	}

	public static void alert() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Primero debe eliminar la conexion");
		alert.setContentText("Primero debes desconectar del sistema de transporte la estacion a eliminar");
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

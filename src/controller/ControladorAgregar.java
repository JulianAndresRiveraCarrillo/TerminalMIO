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
import model.Administrador;

import java.io.IOException;

import javax.swing.JOptionPane;

import excepciones.EstacionRepetidaException;

public class ControladorAgregar {
	
	private Administrador admin = new Administrador();
	
	//===================================================

	//Add GUI
	@FXML
	private TextField nameTF;

	@FXML
	private TextField capacityTF;

	@FXML
    void add(ActionEvent event) {
		String name = " ";
		int capacity = 0;
		
		try {
			
			if ((nameTF.getText().length() == 0)) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Verifica el nombre");
				alert.setContentText("El campo de texto esta vacio");
				alert.showAndWait();
			}else {
				name = nameTF.getText();
				capacity = Integer.parseInt(capacityTF.getText());
				
			if (admin.añadirEstacion(name, capacity) == false) {
				throw new EstacionRepetidaException();
			}
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Se ha agregado correctamente");
				alert.showAndWait();
			}
			
		
		} catch (NumberFormatException nf) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Verifica la Capacidad");
			alert.setContentText("Solo se permiten numeros enteros en el campo de texto");
			alert.showAndWait();
		} catch (EstacionRepetidaException er) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(er.getMessage());
			alert.showAndWait();
		}
		
		
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

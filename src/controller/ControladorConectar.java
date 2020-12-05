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

public class ControladorConectar {
	
	@FXML
	private TextField firstTF;

	@FXML
	private TextField lastTF;

	@FXML
	private TextField distanceTF;
	
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
    public void mostrarVentanaPrincipal(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/principal_1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

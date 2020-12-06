package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

import excepciones.EstacionNoEncontradaException;

public class ControladorBuscar {

	@FXML
    private Label nameLB;

    @FXML
    private Label capacityLB;
    
    @FXML
    private TextField searchTF;
    
    @FXML
    void search(ActionEvent event) {
    	String temp = searchTF.getText();
    	try {
    		if (temp.length() != 0 ) {
    			if (ControladorPrincipal_1.admin.buscar(temp) != null) {
    				nameLB.setText(ControladorPrincipal_1.admin.buscar(temp).getNombre());
    				int num = ControladorPrincipal_1.admin.buscar(temp).getCapacidad_de_usuarios();
    		    	capacityLB.setText(String.valueOf(num));
    			}else {
    				throw new EstacionNoEncontradaException();
    			}
    		}else {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setHeaderText("Verifica las entrada");
    			alert.setContentText("El campo de texto esta vacio");
    			alert.showAndWait();
    		}
		} catch (EstacionNoEncontradaException en) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(en.getMessage());
			alert.showAndWait();
		}
    	
    	
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

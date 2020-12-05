package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControladorBuscar {

	@FXML
    private Label nameLB;

    @FXML
    private Label capacityLB;

    @FXML
    private Label routesLB;
    
    @FXML
    private TextField searchTF;
    
    @FXML
    void search(ActionEvent event) {
    	String temp = searchTF.getText();
    	
    	nameLB.setText("vacio");
    	capacityLB.setText("vacio");
    	routesLB.setText("vacio");
    	
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

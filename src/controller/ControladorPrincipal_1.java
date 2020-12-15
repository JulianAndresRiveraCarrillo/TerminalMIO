package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Administrador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ControladorPrincipal_1 {
	
	public static Administrador admin = new Administrador();
	
    @FXML
    public void ventanaMostrarInformacion(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/informacion.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ventanaAgregarEstacion(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/agregar.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ventanaConectarEstacion(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/conectar.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ventanaEliminarEstacion(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/eliminar.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        ControladorEliminar.alert();
        stage.show();
    }

    @FXML
    public void ventanaBuscarEstacion(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/buscar.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ventanaMostrarRutas(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/rutas.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void guardarInformacion(ActionEvent actionEvent) {
    	saveData();
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Se ha guardado correctamente los registros");
		alert.showAndWait();
    }
    
    public static void loadData() {
    	try {
			FileInputStream file = new FileInputStream("data\\admin.dat");
			ObjectInputStream ois = new ObjectInputStream(file);
			admin = (Administrador) ois.readObject();
			ois.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    public void saveData() {
		try {
			FileOutputStream file = new FileOutputStream("data\\admin.dat");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(admin);
			oos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

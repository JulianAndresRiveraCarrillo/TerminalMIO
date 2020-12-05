package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PrincipalController {
	
	@FXML
	void OpenInfo(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Informacion.fxml"));
		
		fxml.setController(this);
		
		try {
			Parent root = fxml.load();
			Scene sc = new Scene(root);
			Stage st = new Stage();
			st.setScene(sc);
			st.setTitle("Informacion");
			st.setResizable(false);
			st.show();
			
		} catch (IOException io) {
			System.err.println(io.getLocalizedMessage());
		}
	}

	@FXML
	void OpenAdd(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Agregar.fxml"));
		
		fxml.setController(this);
		
		try {
			Parent root = fxml.load();
			Scene sc = new Scene(root);
			Stage st = new Stage();
			st.setScene(sc);
			st.setTitle("Agregar Estacion");
			st.setResizable(false);
			st.show();
			
		} catch (IOException io) {
			System.err.println(io.getLocalizedMessage());
		}
	}
	
	@FXML
	void OpenConnect(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Conectar.fxml"));
		
		fxml.setController(this);
		
		try {
			Parent root = fxml.load();
			Scene sc = new Scene(root);
			Stage st = new Stage();
			st.setScene(sc);
			st.setTitle("Conexion Estacion/Terminal");
			st.setResizable(false);
			st.show();
			
		} catch (IOException io) {
			System.err.println(io.getLocalizedMessage());
		}
	}
	
	@FXML
	void OpenDelete(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Eliminar.fxml"));
		
		fxml.setController(this);
		
		try {
			Parent root = fxml.load();
			Scene sc = new Scene(root);
			Stage st = new Stage();
			st.initModality(Modality.APPLICATION_MODAL);
			st.initStyle(StageStyle.DECORATED);
			st.setScene(sc);
			st.setTitle("Eliminar Estacio/Terminal");
			st.setResizable(false);
			st.show();
			
		} catch (IOException io) {
			System.err.println(io.getLocalizedMessage());
		}
	}
	
	@FXML
	void OpenSearch(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Buscar.fxml"));
		
		fxml.setController(this);
		
		try {
			Parent root = fxml.load();
			Scene sc = new Scene(root);
			Stage st = new Stage();
			st.initModality(Modality.APPLICATION_MODAL);
			st.initStyle(StageStyle.DECORATED);
			st.setScene(sc);
			st.setTitle("BUscar Estacion/Terminal");
			st.setResizable(false);
			st.show();
			
		} catch (IOException io) {
			System.err.println(io.getLocalizedMessage());
		}
	}
	
	@FXML
	void OpenRoute(ActionEvent event) {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Rutas.fxml"));
		
		fxml.setController(this);
		
		try {
			Parent root = fxml.load();
			Scene sc = new Scene(root);
			Stage st = new Stage();
			st.initModality(Modality.APPLICATION_MODAL);
			st.initStyle(StageStyle.DECORATED);
			st.setScene(sc);
			st.setTitle("Estimar Ruta");
			st.setResizable(false);
			st.show();
			
		} catch (IOException io) {
			System.err.println(io.getLocalizedMessage());
		}
	}
}

package controller;

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

	/*
	private AddController addControl;
	private DeleteController deleteControl;
	private SearchController searchControl;
	private RouteController routeControl;

	public PrincipalController() {
		addControl = new AddController();
		deleteControl = new DeleteController();
		searchControl = new SearchController();
		routeControl = new RouteController();

	}*/
	
	@FXML
	void OpenInfo(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/informacion.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Informacion");
		stage.setResizable(false);
		stage.show();
	}

	@FXML
	void OpenAdd(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/agregar.fxml"));
		//fxml.setController(addControl);
		Parent root = loader.load();
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.setScene(sc);
		st.setTitle("Agregar Estacion");
		st.setResizable(false);
		st.show();
	}
	
	@FXML
	void OpenConnect(ActionEvent event) throws IOException{
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Conectar.fxml"));
		
		//fxml.setController(addControl);

		Parent root = fxml.load();
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.setScene(sc);
		st.setTitle("Conexion Estacion/Terminal");
		st.setResizable(false);
		st.show();
	}
	
	@FXML
	void OpenDelete(ActionEvent event) throws IOException{
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Eliminar.fxml"));
		
		//fxml.setController(deleteControl);

		Parent root = fxml.load();
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.initModality(Modality.APPLICATION_MODAL);
		st.initStyle(StageStyle.DECORATED);
		st.setScene(sc);
		st.setTitle("Eliminar Estacio/Terminal");
		st.setResizable(false);
		st.show();
	}
	
	@FXML
	void OpenSearch(ActionEvent event) throws IOException{
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("Buscar.fxml"));
		//fxml.setController(searchControl);
		Parent root = fxml.load();
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.initModality(Modality.APPLICATION_MODAL);
		st.initStyle(StageStyle.DECORATED);
		st.setScene(sc);
		st.setTitle("BUscar Estacion/Terminal");
		st.setResizable(false);
		st.show();
	}
	
	@FXML
	void OpenRoute(ActionEvent event) throws IOException{
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("/gui/rutas.fxml"));
		//fxml.setController(routeControl);
		Parent root = fxml.load();
		Scene sc = new Scene(root);
		Stage st = new Stage();
		st.initModality(Modality.APPLICATION_MODAL);
		st.initStyle(StageStyle.DECORATED);
		st.setScene(sc);
		st.setTitle("Estimar Ruta");
		st.setResizable(false);
		st.show();
	}
}

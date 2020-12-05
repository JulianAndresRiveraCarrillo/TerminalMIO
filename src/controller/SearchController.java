package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchController {

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
}

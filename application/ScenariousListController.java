package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class ScenariousListController implements Initializable {
	//Table
    @FXML
    private TableView<Scenario> tbScenariousList;

    //Columns
    @FXML
    private TableColumn<Scenario, String> colName;

    @FXML
    private TableColumn<Scenario, String> colType;

    //Text input
    @FXML
    private TextField tfName;

    @FXML
    private TextField tfType;
    
    @FXML
    private ImageView btnBack;
    
    @FXML
    private Button btnCreate;
    
    @FXML
    private Pane pnMain;
    
    @FXML
    private Pane pnCreate;
    
    // таблица со списком сценариев

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	colName.setCellValueFactory(new PropertyValueFactory<Scenario, String>("name"));
    	colType.setCellValueFactory(new PropertyValueFactory<Scenario, String>("type"));
    	
    	// Set the font size for the cells
        Font cellFont = new Font(24); // Adjust the font size as needed
        tbScenariousList.setStyle("-fx-font-size: " + cellFont.getSize());
    }

    //Submit button
    @FXML
    void submit(ActionEvent event) {
    	Scenario scenario = new Scenario(tfName.getText(),
    			tfType.getText());
        ObservableList<Scenario> scenarious = tbScenariousList.getItems();
     
        
        scenarious.add(scenario);
        tbScenariousList.setItems(scenarious);
    }
    
    @FXML
    void removeScenario(ActionEvent event) {
        int selectedID = tbScenariousList.getSelectionModel().getSelectedIndex();
        tbScenariousList.getItems().remove(selectedID);
    }
    
    @FXML
	public void back(MouseEvent event) {
		if (event.getSource().equals(btnBack)){
			pnMain.toFront();
		}
	}
    
    @FXML
    public void toCreate(ActionEvent event) {
    	if(event.getSource().equals(btnCreate)) {
    		pnCreate.toFront();
    	}
    }
}

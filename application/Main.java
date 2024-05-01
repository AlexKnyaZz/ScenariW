package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

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


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("authorisation.fxml"));
	        primaryStage.setTitle("ScenariW");
	        primaryStage.centerOnScreen();
	        primaryStage.setResizable(false);
	        
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
	        
	        
	        //Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
	        //primaryStage.setX((screenBounds.getWidth() - primaryStage.getWidth()) / 2);
	        //primaryStage.setY((screenBounds.getHeight() - primaryStage.getHeight()) / 2);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

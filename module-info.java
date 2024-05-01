module ScenariW {
	exports application;
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires com.google.gson;
	
	opens application to javafx.graphics, javafx.fxml;
}

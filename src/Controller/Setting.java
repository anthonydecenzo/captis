package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import Capture.CapturePNG;
import Handler.DataHandler;
import Handler.DirectoryHandler;
import Property.AppSetting;
import application.Main;


public class Setting {
	
	@FXML
	private TextField txtDirectoryLocation;
	@FXML
	private RadioButton radioJPEG, radioPNG;
	@FXML
	private ToggleButton radioSaveLocal;
	
	Stage stage = Main.getStage();
	
	public void handleSaveLocation() {
		DirectoryHandler.init(txtDirectoryLocation.getScene().getWindow());
		String directory = DirectoryHandler.chooseSaveDirectory();
		
		if(directory != null) {
			txtDirectoryLocation.setText(directory);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Empty Directory");
			alert.setContentText("Please enter a valid directory");
			alert.showAndWait();
		}
		
	}
	
	public void handleCapture() {
		CapturePNG p = new CapturePNG();
		p.setDirectorySaveLocation(txtDirectoryLocation.getText());
		p.takeAndSaveCapture();
	}
	
	public void handleMinimize() {
		stage.setIconified(true);
	}
	
	public void handleLoadSettings() {
		AppSetting s = DataHandler.loadData();
		txtDirectoryLocation.setText(s.getDirectorySaveLocation());
		radioJPEG.setSelected(s.isFileTypeJPEG());
		radioPNG.setSelected(s.isFileTypePNG());
		radioSaveLocal.setSelected(s.isSaveFilesOnLocal());
	}
	
	public void handleClose() {
		DataHandler.saveData(new AppSetting(txtDirectoryLocation.getText(), radioSaveLocal.isSelected(), radioJPEG.isSelected(), radioPNG.isSelected()));
		

		stage.close();
	}
}

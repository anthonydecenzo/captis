package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import Controller.Setting;

public class Main extends Application {
	
	private static Stage primary = new Stage();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Setting.fxml/"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Setting controller = loader.getController();
			controller.handleLoadSettings();
			scene.getStylesheets().add(getClass().getResource("/View/application.css").toExternalForm());
			primary.setResizable(false);
			primary.initStyle(StageStyle.UNDECORATED);
			
			primary.setScene(scene);
			primary.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return primary;
	}
}

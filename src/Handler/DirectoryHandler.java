package Handler;

import Controller.Setting;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class DirectoryHandler {

	private static DirectoryChooser chooser;
	private static Window window;
	
	
	public static void init(Window window) {
		DirectoryHandler.window = window;
		chooser = new DirectoryChooser();
		
		
		chooser.setTitle("Browse Directory...");
	}
	
	public static String chooseSaveDirectory() {
		String directory = chooser.showDialog(window).getAbsolutePath();
		
		return directory;
	}
	
}

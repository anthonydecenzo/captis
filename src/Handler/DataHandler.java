package Handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Property.AppSetting;


public class DataHandler {
	
	private final static String DIRECTORY_LOCATION = System.getenv("APPDATA") + "\\Captis";
	private final static String SETTING_FILE_LOCATION = System.getenv("APPDATA") + "\\Captis\\settings.ser";

		public static void saveData(AppSetting setting) {
			File fileLoc = new File(SETTING_FILE_LOCATION);
			File directory = new File(DIRECTORY_LOCATION);
			do {
				
				if(directory.exists()) {
					if(fileLoc.exists()) {
						try {

							FileOutputStream fos = new FileOutputStream(SETTING_FILE_LOCATION);
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(setting);
							
							oos.close();
							fos.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						try {
							fileLoc.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					directory.mkdirs();
				}

			} while(!directory.exists());
		}
		
		public static AppSetting loadData() {
			File fileLoc = new File(SETTING_FILE_LOCATION);
			File directory = new File(DIRECTORY_LOCATION);
			AppSetting setting = null;
			if(directory.exists() && fileLoc.exists()) {
				
				FileInputStream fis = null;
				ObjectInputStream ois = null;
				
				try {
					
					fis = new FileInputStream(SETTING_FILE_LOCATION);
					
					if(fis.available() != 0) {
						ois = new ObjectInputStream(fis);
						
							setting = (AppSetting) ois.readObject();
						
							

						ois.close();
						fis.close();
					}

				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			return setting;
		}
}

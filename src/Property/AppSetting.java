package Property;

import java.io.Serializable;

public class AppSetting implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private boolean saveFilesOnLocal, fileTypeJPEG, fileTypePNG;
	private String directorySaveLocation;
	
	public AppSetting(String directorySaveLocation, boolean saveFilesOnLocal, boolean fileTypeJPEG, boolean fileTypePNG) {
		this.directorySaveLocation = directorySaveLocation;
		this.saveFilesOnLocal = saveFilesOnLocal;
		this.fileTypePNG = fileTypePNG;
	}
	
	public boolean isSaveFilesOnLocal() {
		return saveFilesOnLocal;
	}
	public void setSaveFilesOnLocal(boolean saveFilesOnLocal) {
		this.saveFilesOnLocal = saveFilesOnLocal;
	}
	public boolean isFileTypeJPEG() {
		return fileTypeJPEG;
	}
	public void setFileTypeJPEG(boolean fileTypeJPEG) {
		this.fileTypeJPEG = fileTypeJPEG;
	}
	public boolean isFileTypePNG() {
		return fileTypePNG;
	}
	public void setFileTypePNG(boolean fileTypePNG) {
		this.fileTypePNG = fileTypePNG;
	}
	public String getDirectorySaveLocation() {
		return directorySaveLocation;
	}
	public void setDirectorySaveLocation(String directorySaveLocation) {
		this.directorySaveLocation = directorySaveLocation;
	}
	
}

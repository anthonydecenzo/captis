package Template;

import Enum.CaptureType;

public interface Capture {
	
	String directorySaveLocation = null;
	CaptureType captureType = null;
	
	CaptureType getCaptureType();

	void setCaptureType(CaptureType captureType);

	String getDirectorySaveLocation();
	
	void setDirectorySaveLocation(String directorySaveLocation);	
}

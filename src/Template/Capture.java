package Template;

import java.awt.Robot;
import java.text.SimpleDateFormat;

import Enum.CaptureType;

public abstract class Capture {
	protected String directorySaveLocation = null;
	protected CaptureType captureType = null;
	protected Robot robot;
	protected SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyDDMM hh-mm");
	
	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	protected abstract void saveCapture();

	
	protected CaptureType getCaptureType() {
		return captureType;
	}

	protected void setCaptureType(CaptureType captureType) {
		this.captureType = captureType;
	}

	protected String getDirectorySaveLocation() {
		return directorySaveLocation;
	}
	
	protected void setDirectorySaveLocation(String directorySaveLocation) {
		this.directorySaveLocation = directorySaveLocation;
	}
}

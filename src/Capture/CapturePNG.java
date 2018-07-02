package Capture;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import Template.Capture;

public class CapturePNG extends Capture{
	
	public CapturePNG() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void takeAndSaveCapture() {
		Calendar now = Calendar.getInstance();
		BufferedImage capture = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		File file = new File(directorySaveLocation + "\\" + dateFormat.format(now.getTime()) + ".png");
		System.out.println(file.getAbsolutePath());
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			ImageIO.write(capture, "PNG", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

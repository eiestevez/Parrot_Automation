package com.parrot.automation.config;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class TakeEvidence {
	
	boolean resultFlag;
	Date dateFile = new Date();
	DateFormat DateFormatFile = new SimpleDateFormat("HH-mm");
	String _TIME_EXECUTION = DateFormatFile.format(dateFile);
	
    public boolean ScreenShot(AndroidDriver<AndroidElement> driver)
    {
        resultFlag = Boolean.FALSE;
        Date date = new Date();
    	DateFormat DateFormatFileImage = new SimpleDateFormat("HHmmss");
    	String _TIME_EXECUTION_FILE = DateFormatFileImage.format(date);

        try
        {
            File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(FolderToDay(Constantes.BASE_PATH_EVIDENCE)+_TIME_EXECUTION_FILE+Constantes.IMG_FORMATO));
            resultFlag = Boolean.TRUE;
        }
        catch (Exception e)
        {
            System.out.println("Error en - ScreenShot() " + e.getMessage());
            resultFlag = Boolean.FALSE;
        }
        return resultFlag;
    }
    
    public boolean ScreenRecord(AndroidDriver<AndroidElement> driver)
    {
        resultFlag = Boolean.FALSE;

        try
        {
//        	((CanRecordScreen)driver).startRecordingScreen(new AndroidStartScreenRecordingOptions()....);
            resultFlag = Boolean.TRUE;
        }
        catch (Exception e)
        {
            System.out.println("Error en - ScreenRecord() " + e.getMessage());
            resultFlag = Boolean.FALSE;
        }
        return resultFlag;
    }
    
    public String FolderToDay(String BASE_PATH_EVIDENCE)
    {
    	DateFormat DateFormatFolder = new SimpleDateFormat("yyyy-MM-dd");
        String DATE_EXECUTION = DateFormatFolder.format(dateFile).toString();
        String TIME_EXECUTION = _TIME_EXECUTION;
        String PATH = BASE_PATH_EVIDENCE + DATE_EXECUTION + "\\" + TIME_EXECUTION + "\\";
    	File FOLDER = new File(PATH);
        if (!FOLDER.exists())
        {
        	File folder = new File(PATH);
        	folder.mkdir();
        }
        return PATH;
    }

}

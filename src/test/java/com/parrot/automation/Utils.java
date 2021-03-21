package com.parrot.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import com.parrot.automation.config.Constantes;
import com.parrot.automation.config.TakeEvidence;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utils {

	boolean resultFlag;
	Logger log = Logger.getLogger(TestUnit.class);
	Properties properties = new Properties();
	TakeEvidence te = new TakeEvidence();

    public By dynamicObject(String IdObject)
    {
        By dynamicObj = null;
        boolean Identificator = IdObject.contains("//");

        if (Identificator)
		{
            dynamicObj = By.xpath(IdObject);
		}
		else
		{
            dynamicObj = By.id(IdObject);
		}
        return dynamicObj;
    }
	
    public boolean SetValue(AndroidDriver<AndroidElement> driver, String IdObject, String text) {
    	resultFlag = Boolean.FALSE;
    	try {
			driver.findElement(dynamicObject(IdObject)).sendKeys(text);
			resultFlag = Boolean.TRUE;
		} catch (Exception e) {
        	resultFlag = Boolean.FALSE;
            System.out.println("Ocurrio un error en - SetValue() " + e.getMessage());	
        	WriteLog("Ocurrio un error en - SetValue() ", "error");		
            }
    	return resultFlag;
    }
	
    public boolean Click(AndroidDriver<AndroidElement> driver, String IdObject) {
    	resultFlag = Boolean.FALSE;
    	try {
			driver.findElement(dynamicObject(IdObject)).click();
			Wait(1);
			te.ScreenShot(driver);
        	resultFlag = Boolean.TRUE;

		} catch (Exception e) {
        	resultFlag = Boolean.FALSE;
            System.out.println("Ocurrio un error en - Click() " + e.getMessage());	
        	WriteLog("Ocurrio un error en - Click() ", "error");		
            }
    	return resultFlag;
    }

    public boolean Displayed(AndroidDriver<AndroidElement> driver, String IdObject) {
    	resultFlag = Boolean.FALSE;
    	try {
			driver.findElement(dynamicObject(IdObject)).isDisplayed();
			resultFlag = Boolean.TRUE;
		} catch (Exception e) {
        	resultFlag = Boolean.FALSE;
            System.out.println("Ocurrio un error en - Displayed() " + e.getMessage());	
        	WriteLog("Ocurrio un error en - Displayed() ", "error");		
            }
    	return resultFlag;
    }
    
    public String GetText(AndroidDriver<AndroidElement> driver, String IdObject) {
    	String SavedText = "";
    	try {
			SavedText = driver.findElement(dynamicObject(IdObject)).getText();
		} catch (Exception e) {
            System.out.println("Ocurrio un error en - GetText() " + e.getMessage());	
        	WriteLog("Ocurrio un error en - GetText() ", "error");
            }
    	return SavedText;
    }
    
    public boolean Wait (int seconds) {
    	resultFlag = Boolean.FALSE;
        try {
            Thread.sleep(seconds * 1000);
            resultFlag = Boolean.TRUE;
        } catch (Exception e) {
        	resultFlag = Boolean.FALSE;
            System.out.println("Ocurrio un error en - Wait() " + e.getMessage());	
        	WriteLog("Ocurrio un error en - Wait() ", "error");
        }
        return resultFlag;
    }
    
    public boolean WriteLog(String Message, String TypeLog)
    {
        resultFlag = Boolean.FALSE;

        try
        {
        	properties.load(new FileInputStream(Constantes.LOG_FILE));
        	PropertyConfigurator.configure(properties);

            switch (TypeLog)
            {
                case "info":
                    log.info(Message);
                    break;
                case "error":
                    log.error(Message);
                    break;
            }
            resultFlag = Boolean.TRUE;

        }
        catch (Exception e)
        {
            resultFlag = Boolean.FALSE;
            System.out.println("Ocurrio un error en - WriteLog() " + e.getMessage());	
        	WriteLog("Ocurrio un error en - WriteLog() ", "error");
        }
        return resultFlag;
    }

    public boolean ReadExcel()
    {
        resultFlag = Boolean.FALSE;

        try
        {
             FileInputStream inputStream = new FileInputStream(new File(Constantes.INPUT_EXCEL+"InputsParrot_TestAutomation.xlsx"));
              
             XSSFWorkbook wb = new XSSFWorkbook(inputStream);
             XSSFSheet shett = wb.getSheet("InputsParrot");
             
             int numFilas = shett.getLastRowNum();
             
             for (int i = 0; i < numFilas; i++) {
				
            	 Row fila = shett.getRow(i);
            	 int numCols = fila.getLastCellNum();
            	 
            	 for (int j = 0; j < numCols; j++) {
					
            		 Cell celda = fila.getCell(j);
            		 System.out.print(celda.getStringCellValue() +" ");
				}
                 System.out.println("-");
			}                         
            resultFlag = Boolean.TRUE;

        }
        catch (Exception e)
        {
            resultFlag = Boolean.FALSE;
            System.out.println("Ocurrio un error en - ReadExcel() " + e.getMessage());	
        	WriteLog("Ocurrio un error en - ReadExcel() ", "error");
        }
        return resultFlag;
    }
}

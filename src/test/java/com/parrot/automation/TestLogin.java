package com.parrot.automation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.parrot.automation.config.Constantes;
import com.parrot.automation.config.TakeEvidence;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class TestLogin {

	boolean resultFlag;
	Utils u = new Utils();
	TakeEvidence te = new TakeEvidence();
    TakeEvidence tss = new TakeEvidence();


	@Test
    public void LoginExitoso(AndroidDriver<AndroidElement> driver){
		
        try {
        	u.WriteLog("Inicia ejecucion de TC - Login Exitoso", "info");
        	u.Wait(2);
        	u.SetValue(driver,"editEmail", "android-challenge@parrotsoftware.io");
        	u.SetValue(driver,"editPassword", "8mngDhoPcB3ckV7X");
        	te.ScreenShot(driver);
        	u.Click(driver,"//*[@class='android.widget.Button' and @index='6' and @text='INICIAR SESIÓN']");
        	u.Wait(2);
        	te.ScreenShot(driver);
        	String LblPtnInicial = u.GetText(driver,"//*[@class='android.widget.TextView' and @index='0' and @text='Store Android Challenge']");
        	assertEquals(LblPtnInicial, "Store Android Challenge");
        	u.WriteLog("TC Login exitoso - SUCCESS", "info");
        	
        } catch (Exception e) {
        	u.WriteLog("Error in TestCase - LoginExitoso() ", "error");
            System.out.println("Error in TestCase - LoginExitoso() " + e.getMessage());
        } 
    }
	
	@Test
    public void LoginIncorrecto(AndroidDriver<AndroidElement> driver){
		
        try {
        	u.WriteLog("Inicia ejecucion de TC - Login Incorrecto", "info");
        	u.Wait(2);
        	u.SetValue(driver,"editEmail", "Ivan Estevez");
        	u.SetValue(driver,"editPassword", "PassTest");
        	te.ScreenShot(driver);
        	u.Click(driver,"//*[@class='android.widget.Button' and @index='6' and @text='INICIAR SESIÓN']");
        	te.ScreenShot(driver);
        	u.WriteLog("TC Login Incorrecto - SUCCESS", "info");
        	
        } catch (Exception e) {
        	u.WriteLog("Error in TestCase - LoginIncorrecto() ", "error");
            System.out.println("Error in TestCase - LoginIncorrecto() " + e.getMessage());
        } 
    }
    
}

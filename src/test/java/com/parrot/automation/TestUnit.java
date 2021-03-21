package com.parrot.automation;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

import com.parrot.automation.config.Constantes;
import com.parrot.automation.config.TakeEvidence;

public class TestUnit{
			
	AndroidDriver<AndroidElement> driver = null;
	boolean resultFlag;
	Utils u = new Utils();
    TakeEvidence tss = new TakeEvidence();
    TestLogin tl = new TestLogin();
    TestPedidos tp = new TestPedidos();
	
	@Before
	public void SetUp() throws MalformedURLException {

		try {
//			u.ReadExcel();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("VERSION", "9.0"); 
		capabilities.setCapability("deviceName","RZ8N11MDLJK");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("app", Constantes.APK_PATH + Constantes.APK);
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        u.WriteLog("APK Iniciada correctamente", "info");
        tss.ScreenShot(driver);
		}
		catch(Exception e){
        	u.WriteLog("Error en - SetUp() ", "error");
            System.out.println("Error en - SetUp() " + e.getMessage());
		}
	}
	
	@Test
	public void TC_Login() {
		tl.LoginExitoso(driver);
	}
	
	@Test
	public void TC_LookFeelPantallaPedidos() {
		tp.LookandFeelPantallaPedidos(driver);
	}

	@Test
	public void TC_ValidaSwitch_CombosEspeciales() {
		tp.ValidaSwitch_CombosEspeciales(driver);
	}
	
	@Test
	public void TC_ValidaSwitch_Combo30cm() {
		tp.ValidaSwitch_Combo30cm(driver);
	}
	
	@Test
	public void TC_ValidaSwitch_Promociones() {
    tp.ValidaSwitch_Especialidades(driver);
	}
	
	@Test
	public void TC_ValidaSwitch_Especialidades() {
		tp.ValidaSwitch_Especialidades(driver);
	}

    @After
    public void tearDown(){
        driver.quit();
    }
}

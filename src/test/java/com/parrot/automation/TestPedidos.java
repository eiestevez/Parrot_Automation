package com.parrot.automation;

import org.junit.Test;
import com.parrot.automation.config.TakeEvidence;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestPedidos {

	boolean resultFlag;
	Utils u = new Utils();
	TakeEvidence te = new TakeEvidence();
	TestLogin tl = new TestLogin();
	
	@Test
    public void LookandFeelPantallaPedidos(AndroidDriver<AndroidElement> driver){
		
        try {
        	tl.LoginExitoso(driver);
        	u.WriteLog("Inicia ejecucion de TC - Look & Feel Pantalla Pedidos", "info");
        	u.Displayed(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Combos Especiales']");
        	u.WriteLog("Se valido Existencia del elemento - Combos Especiales", "info");
        	u.Displayed(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Combo 30 cm']");
        	u.WriteLog("Se valido Existencia del elemento - Combo 30 cm", "info");
        	u.Displayed(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Promociones']");
        	u.WriteLog("Se valido Existencia del elemento - Promociones", "info");
        	u.Displayed(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Especialidades']");
        	u.WriteLog("Se valido Existencia del elemento - Especialidades", "info");
        	       	
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Combos Especiales']");
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Combo 30 cm']");
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Promociones']");
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Especialidades']");
        	
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Combos Especiales']");
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Combo 30 cm']");
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Promociones']");
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Especialidades']");
        	
        	u.WriteLog("TC - Look & Feel Pantalla Pedidos - SUCCESS", "info");
        	
        } catch (Exception e) {
        	u.WriteLog("Error in TestCase - LookandFeelPantallaPedidos() ", "error");
            System.out.println("Error in TestCase - LookandFeelPantallaPedidos() " + e.getMessage());
        } 
    }
    
	@Test
    public void ValidaSwitch_CombosEspeciales(AndroidDriver<AndroidElement> driver){
		
        try {
        	tl.LoginExitoso(driver);
        	u.WriteLog("Inicia ejecucion de TC - ValidaSwitch_CombosEspeciales", "info");
        	
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Combos Especiales']");
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,297][692,344]']");
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,359][692,406]']");
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,421][692,468]']");
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,483][692,530]']");
        	
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,297][692,344]']");
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,359][692,406]']");
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,421][692,468]']");
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,483][692,530]']");
        	        	
        	u.WriteLog("TC - ValidaSwitch_CombosEspeciales - SUCCESS", "info");
        	
        } catch (Exception e) {
        	u.WriteLog("Error in TestCase - ValidaSwitch_CombosEspeciales() ", "error");
            System.out.println("Error in TestCase - ValidaSwitch_CombosEspeciales() " + e.getMessage());
        } 
    }
    
	@Test
    public void ValidaSwitch_Combo30cm(AndroidDriver<AndroidElement> driver){
		
        try {
        	tl.LoginExitoso(driver);
        	u.WriteLog("Inicia ejecucion de TC - ValidaSwitch_Combo30cm", "info");
        	
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Combo 30 cm']");
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,435][692,482]']");

        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,435][692,482]']");  
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Combo 30 cm']");
        	u.WriteLog("TC - ValidaSwitch_Combo30cm - SUCCESS", "info");
        	
        } catch (Exception e) {
        	u.WriteLog("Error in TestCase - ValidaSwitch_Combo30cm() ", "error");
            System.out.println("Error in TestCase - ValidaSwitch_Combo30cm() " + e.getMessage());
        } 
    }
    
	@Test
    public void ValidaSwitch_Promociones(AndroidDriver<AndroidElement> driver){
		
        try {
        	tl.LoginExitoso(driver);
        	u.WriteLog("Inicia ejecucion de TC - ValidaSwitch_Promociones", "info");
        	
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Promociones']");
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,573][692,620]']");

        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,573][692,620]']");     
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Promociones']");
        	u.WriteLog("TC - ValidaSwitch_Promociones - SUCCESS", "info");
        	
        } catch (Exception e) {
        	u.WriteLog("Error in TestCase - ValidaSwitch_Promociones() ", "error");
            System.out.println("Error in TestCase - ValidaSwitch_Promociones() " + e.getMessage());
        } 
    }
    
	@Test
    public void ValidaSwitch_Especialidades(AndroidDriver<AndroidElement> driver){

        try {
        	tl.LoginExitoso(driver);
        	u.WriteLog("Inicia ejecucion de TC - ValidaSwitch_Especialidades", "info");
        	
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Especialidades']");
        	u.Click(driver, "//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,711][692,758]']");

        	u.Click(driver,"//*[@class='android.widget.Switch' and @index='1' and @bounds='[610,711][692,758]']");   
        	u.Click(driver, "//*[@class='android.widget.TextView' and @index='1' and @text='Especialidades']");
        	u.WriteLog("TC - ValidaSwitch_Especialidades - SUCCESS", "info");
        	
        } catch (Exception e) {
        	u.WriteLog("Error in TestCase - ValidaSwitch_Especialidades() ", "error");
            System.out.println("Error in TestCase - ValidaSwitch_Especialidades() " + e.getMessage());
        } 
    }
    
}

package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class PracticaM4 {
	
	WebDriver driver;
	
    String url = "http://www.automationpractice.pl";
    
    
    @BeforeSuite
	public void openBrowser () {
		  driver = new FirefoxDriver();
		  driver.get(url);
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  
  }
	
	
	
	@Test
	public void login() {
		// 1) Click Sign In
		
		HomePage inicio = new HomePage(driver);
		inicio.clickSignIn();
		
		
		// 2) Completar el correo y contrasena
		
		LoginPage login  = new LoginPage(driver);
		
		login.writeEmail("correo@gmail.com");
		login.writePass("12345abc");
		// LoginPage login = new LoginPage(driver);
		//login.ingresarCredenciales("correo@gmail.com", "12345abc");
		
		
		// 3) Hacer click en el boton Login
		login.clickLogin();
		
	  
		
	}
	
	
	
	
	@Test 
	public void searchWord () {
		HomePage inicio = new HomePage(driver);
		inicio.writeWord("dress");
		inicio.clickSearch();
		
	}
		
	
	
	@AfterSuite 
	public void closeDriver () {
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

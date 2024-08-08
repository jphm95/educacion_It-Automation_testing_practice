package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;


public class PracticaM4b {
 
  	  String url = "http://www.automationpractice.pl/index.php";
	  WebDriver driver;
  	
  	  
  	  @BeforeTest
  	  @Parameters("browser")
  	  public void openBrowser(String browser) {
  		  
  		  if (browser.equalsIgnoreCase("Chrome")) {
  			  WebDriverManager.chromedriver().setup();
  			  driver = new ChromeDriver();
  		  } else if (browser.equalsIgnoreCase("Edge")) {
  			  driver = new EdgeDriver();
  		  } else if (browser.equalsIgnoreCase("Firefox")) {
  			  driver = new  FirefoxDriver();
  		  } else if (browser.equalsIgnoreCase("Safari")) {
  			  driver = new SafariDriver();
  		  }
  		  
  		  
  		  driver.get(url); 
  		  driver.manage().window().maximize();
  		  driver.manage().deleteAllCookies();
  		  
  	  }
	
	
	  @Test
      public void writeWord() {
		 HomePage inicio = new HomePage(driver);
		 inicio.writeWord("dress");
		 inicio.clickSearch();	 
	
		  
		  
		  
		  
	 }
	 
	
	public void closeDriver() {
		driver.close();
	}
	
	
	
}

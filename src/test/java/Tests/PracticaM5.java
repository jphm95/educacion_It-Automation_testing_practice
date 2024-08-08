package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.PaginaAlerta;

public class PracticaM5 {
	
	

	String url = "http://demoqa.com/alerts";
	WebDriver driver;
	
	
	
	@BeforeSuite
	public void openBrowser () {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		double zoom = 0.67;
		options.addArguments("--force-device-scale-factor=" + zoom);
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();	
		
	}

	@Test	
	public void  usarAlerta1 () {
	// 1) Hacer click en el boton de la pagina
	PaginaAlerta pagina = new PaginaAlerta(driver);
	pagina.clickNotification();
		
	
	
	// 2) Obtener la alerta
	Alert alerta = pagina.obtenerAlerta();
	
	// Mostrar en la consola el texto de la alerta
	System.out.println(pagina.obtenerTextoAlerta(alerta));	
	
	//3) Simular "Aceptar" en la alerta
	pagina.hacerClickEnAceptar(alerta);
	
	}		
			
			
			
	@Test
	public void usarAlert2 () 
	{
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClickEnEspera();
		
		Alert alerta = pagina.obtenerAlerta();
		pagina.hacerClickEnAceptar(alerta);
	}
	
	@Test		
    public void usarAlerta3() {
         PaginaAlerta pagina =  new PaginaAlerta(driver);
         pagina.hacerClickEnCancelar();
         
         Alert alerta = pagina.obtenerAlerta();
         pagina.hacerClickEnCancelar(alerta);
    	
    }
			
			
	public void usarAlerta4() {
        PaginaAlerta pagina =  new PaginaAlerta(driver);
        pagina.hacerClickEnPrompt();
        	        
        Alert alerta = pagina.obtenerAlerta();
        pagina.escribirEnAlerta(alerta, "Clase de Automatizacion");
        pagina.hacerClickEnAceptar(alerta);
        
	}
			
			
			
}


 
	
	
	
	
	


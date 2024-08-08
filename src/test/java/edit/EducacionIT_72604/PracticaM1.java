package edit.EducacionIT_72604;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Informacion sobre las librerias necesarias para estas pruebas


public class PracticaM1 {
    // Definicion de variables de uso comun
	String url = "http://www.automationpractice.pl/";
	
	// Metodos de Prueba 
	@Test
	public void buscarPalabraEnChrome() {
		// 1) Definir que navegador utilizamos
		WebDriver browser = new ChromeDriver();
		
		// 2) Abrir la pagina de prueba
		browser.get(url); // Otra forma navegador.navigate().to(url);
		browser.manage().window().maximize();  // Maximizar la ventana
		browser.manage().deleteAllCookies();   // Borrar las cookies
		// 3) Escribir una palabra a buscar
		WebElement txtBuscador = browser.findElement(By.id("search_query_top")); //Buscar elemento 
		txtBuscador.clear(); // Limpiar el valor que tenia antes un campo de texto
		txtBuscador.sendKeys("dress");
		
		// Alternativa: Simular que presionamos la tecla ENTER
		txtBuscador.sendKeys(Keys.ENTER);
		
		// 4) Hacer click en "la lupita" (boton de busqueda)
		WebElement btnBuscar = browser.findElement(By.name("submit_search"));
		btnBuscar.click(); 
		
		browser.close();   // Cerrar la ventana actual 
		// navegador.quit();    // Cerrar todas las ventanas que se hayan abierto durante la prueba
		
		
	}
		
		
		@Test
		public void buscarPalabraEnFirefox() {
			// 1) Definir que navegador utilizamos
			WebDriver navegador = new FirefoxDriver();
			
			// 2) Abrir la pagina de prueba
			navegador.get(url); // Otra forma navegador.navigate().to(url);
			
			// 3) Escribir una palabra a buscar
			WebElement txtBuscador = navegador.findElement(By.id("search_query_top")); //Buscar elemento 
			txtBuscador.sendKeys("dress");
			// 4) Hacer click en "la lupita" (boton de busqueda)
			WebElement btnBuscar = navegador.findElement(By.name("submit_search"));
			btnBuscar.click();
				
		    navegador.close();
		
	}
	
	
	
	
	
	
	
	
}

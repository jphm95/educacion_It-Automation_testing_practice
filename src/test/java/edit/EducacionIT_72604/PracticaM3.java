package edit.EducacionIT_72604;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utilities.CapturaEvidencia;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

 public class PracticaM3 {

	String  url =  "http://www.automationpractice.pl";
	
	WebDriver driver;
	
	File screen;
	
	String dirEvidencias = "..//EducacionIT-72604//Evidencias//";  //"..\\EducacionIT-72604\\Evidencias\\";
	
			//"/Users/juanpablohernandezmonter/eclipse-workspace/
	String nombreImagen = "img.jpg";
	
	String nombreDocumento = "Documento de Evidencias.docx";
	
	
	@BeforeSuite
	public void abrirNavegador () {
		
    driver = new ChromeDriver();
		
	driver.get(url);
	
	driver.manage().window().maximize();
		
		
		
		
		
	}
	
	
	
	
	
	@Test (description = "CP02 - Buscar Palabra", priority=200)
	                                 // si la captura falla, falla el test
	public void buscarPalabreChrome() throws IOException {
		
		//Hacer captura de Pantalla antes de la busqueda de la palabra
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "1_pantallaPrincipal.jpg")); 
		
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));	
		
		txtBuscador.sendKeys("dress");
		
		//Hacer captura de Pantalla antes de la busqueda de la palabra
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "2_palabraBuscar.jpg")); 
		
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		 
		//Hacer captura de Pantalla de resultados de la busqueda
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(dirEvidencias + "3_resultadosBusqueda.jpg")); 
		
	    // Modulo 3: Assertions (incorporar validaciones)
		
		String tituloEsperado = "Search - My Shop";
		String tituloActual = driver.getTitle();
				
		Assert.assertEquals(tituloActual, tituloEsperado);
		
		
		 /*
		  * Assert.assertNotEquals("A", "B");
		  * Assert.assertTrue (1 == 2);
		  * Assert.assertFalse(1 == 2);
		  * Assert.Null(null);
		  * AssertNotNull(tituloActual);
		  * 
		  * SoftAssert: validacion "suave" 
		  * 
		  * SoftAssert aoft = new SoftAssert();
		  * soft.assertEquals(tituloActual, tituloEsperado);
		  * 
		  */
		
		
		
		
		//driver.close();		
		
	 	
	  }
	
	
	
	@Test  (description = "CP02 - Buscar Palabra", priority=100) 
	// (priority=200) ejecuta el numero mas pequeno
   // (description="CP02 - Ir a Contactanos", priority=100)
	public void irAContatanos() throws InvalidFormatException, IOException, InterruptedException  { 
		// Capturar Evidencias
		
		CapturaEvidencia.escribirTituloEnDocumento(
				            dirEvidencias + nombreDocumento,  
				            "Documento de Evidencias -Automation Practice", 
				             20);
		
		
		CapturaEvidencia.capturarPantallaEnDocumento(
				         driver, dirEvidencias + nombreImagen, 
				         dirEvidencias + nombreDocumento,
				         "Paso 1 - Pantalla Inicial");
		
		// 1. Hacer click en Contac Us
		WebElement linkContact = driver.findElement(By.linkText("Contact us"));
		linkContact.click();
		
		
		CapturaEvidencia.capturarPantallaEnDocumento(
				         driver, dirEvidencias + nombreImagen, 
				         dirEvidencias + nombreDocumento,
				         "Paso 2 - Pantalla Formulario");
		
		
		// 2. Rellenar el Formulario
		Select selSubject = new Select(driver.findElement(By.id("id_contact")));
		selSubject.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
		txtEmail.sendKeys("correo@gmail.com");
		
		WebElement textOrder = driver.findElement(By.name("id_order"));
		textOrder.sendKeys("B787A350");
		
		WebElement fillAttached= driver.findElement(By.cssSelector("#fileUpload"));
		fillAttached.sendKeys("/Users/juanpablohernandezmonter/Library/Mobile Documents/com~apple~TextEdit/Documents/driversname .rtf");
		
		WebElement textMessage = driver.findElement(By.tagName("textarea"));
		textMessage.sendKeys("Mensaje de Contacto del Cliente");
		
		// Capturar Evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(
		         driver, dirEvidencias + nombreImagen, 
		         dirEvidencias + nombreDocumento,
		         "Paso 3 - Formulario llenado ");

		
		
		// 3. Click en el boton Send
		
		WebElement buttonSend = driver.findElement(By.id("submitMessage"));
		buttonSend.click();
		
		
		// Capturar Evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(
		                 driver, dirEvidencias + nombreImagen, 
		                 dirEvidencias + nombreDocumento,
		                 "Paso 4 - Formulario enviado");		
		
		
		
		
		
	}
	
	
	
	
	
		
	 @AfterSuite
	 public void cerrarNavegador() {
		 
		 driver.close();
		 
		 
		 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	}



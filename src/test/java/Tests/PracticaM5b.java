package Tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.CapturaEvidencia;
import utilities.DatosExcel;

public class PracticaM5b {
	
	String url = "http://www.automationpractice.pl/index.php";
	WebDriver  driver;
    String dirEvidencias = "..//EducacionIT-72604//Evidencias//";
    String nombreImagen = "img.jpg";	
	String nombreDocumento = "Documento de Evidencias.docx";
	
	@BeforeSuite
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
	}
	
	@Test(dataProvider="Datos Login Excel")
	public void login(String email, String password) throws IOException, InvalidFormatException, InterruptedException {
		HomePage inicio = new HomePage(driver);
		inicio.clickSignIn();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias, nombreDocumento = "Pagina Home, antes de login",
				         nombreImagen = "imagen1.jpg");
		
		LoginPage login = new LoginPage(driver);
		login.writeEmail(email);
		login.writePass(password);
		login.clickLogin();
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias, nombreDocumento = "Login Exitoso",
		         nombreImagen = "imagen2.jpg");
		// Volver a la posicion inicial de la prueba
		
		
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		
		datos [0][0] = "abc@gmail.com";  // Debe coincidir con los parametros del "login"
		datos [0][1] = "123";
		
		datos [1][0] = "aca@gmail.com";
		datos [1][1] = "456";
		
		datos [2][0] = "ana@gmail.com";
		datos [2][1] = "789";
		
		return datos;
		
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		// Leer un archivo Excel y devolver los datos como Object
		String nombreExcel = "..//EducacionIT-72604//Datos//datos_login_03Julio2024.xlsx";
		String nombreHoja = "Hoja1";		
		
		return DatosExcel.leerExcel(nombreExcel, nombreHoja);		
		
	}
	
	@AfterSuite
	public void tearDown () {
		driver.close();
	}
	
	
	
	
	
	
}

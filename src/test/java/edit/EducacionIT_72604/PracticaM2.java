package edit.EducacionIT_72604;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticaM2 {

	String url = "http://www.automationpractice.pl";
	
	
	@Test 
	public void createAccount() {
		// (1) Definir que navegador usar
		
		WebDriver driver = new FirefoxDriver();
		
		// (2) Abrir la pagina de prueba
		driver.navigate().to(url);
		driver.manage().window().maximize();
	
		// (3) Hacer click en el hipervinculo Sign in
		WebElement lnkSign = driver.findElement(By.partialLinkText("Sign"));
		lnkSign.click();
		// Otra forma 
		// driver.findElement(By.partialLinkText("Sign")).click();
		
		// (4) Escribir el correo electronico
		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create"));
		txtEmail.sendKeys("12dejunio@correo.com");
		
		// (5) Gacer click en el boton "Create Account"
		WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		// (6) Completar el formulario 
	
		// Sumar una espera por una demora en la carga del formulario
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		WebElement radTittle = driver.findElement(By.id("id_gender1"));
		radTittle.click();
		
		WebElement txtName = driver.findElement(By.name("customer_firstname"));
		txtName.sendKeys("Pablo");
		
		WebElement txtLastName = driver.findElement(By.cssSelector("#customer_lastname"));
		txtLastName.sendKeys("HM");
		
		// Opcion 1Generar un correo con un numero aleatorio
		String email = "correo" + Math.random() + "@micorreo.com";
		
		// Opcion 2 Utilizar una libreria de generacion de datos aleatorios //java Faker
		//faker = new faker
		//String email = faker.internet.emailAdress();
				
	    WebElement txtEmail2 = driver.findElement(By.xpath("//input[@id='email']"));
		txtEmail2.clear();
		txtEmail2.sendKeys(email);
		
		WebElement txtPassword = driver.findElement(By.id("passwd"));
		txtPassword.sendKeys("12345");
		//Lista desplegable
		Select day = new Select(driver.findElement(By.id("days")));
		day.selectByValue("14");
		
		Select month = new Select(driver.findElement(By.name("months")));
		month.selectByVisibleText("June ");
		
		Select year = new Select(driver.findElement(By.cssSelector("#years")));
		year.selectByIndex(30);
		
		
		WebElement checkNews = driver.findElement(By.name("newsletter"));
		checkNews.click();
		
		/*(7) Hacer click en el boton "Register"
		WebElement registerButton = driver.findElement(By.id("submitAccount"));
		registerButton.click(); */
		// (8) Cerrar el navegador
		
		driver.close();
		
		
		
	}
	
	
	
	
	
	
	
}

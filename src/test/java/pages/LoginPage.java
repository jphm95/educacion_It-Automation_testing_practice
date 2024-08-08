package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(css="#email")
	WebElement emailField;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement passField;
	
	@FindBy(id="SubmitLogin")
	WebElement loginButton;
	
	
	//Constructor 
	
	public LoginPage (WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Acciones
	
	public void writeEmail (String email) {
		emailField.sendKeys(email);
		
		
	}
	
    public void writePass (String password) {
		passField.sendKeys(password);
		
		
	}
	
    public void clickLogin () {
	   loginButton.click();
	
    }   
	   
	public void ingresarCredenciales(String email, String password) {
		emailField.sendKeys(email);
		passField.sendKeys(password);
		loginButton.click();
	   
	   
	   
	
 }
	
	
	
}

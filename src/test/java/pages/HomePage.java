package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	 // elementos que voy a utilizar en la pagina
	 @FindBy(partialLinkText="Sign")
	 WebElement linkSignIn;
	
	 @FindBy(name="search_query")
	 WebElement txtSearch;
	 
	 @FindBy(name="submit_search")
	 WebElement buttonSearch;
	 
	 
	// Constructor
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	
	// Acciones que se pueden hacer sobre los elementos web
	 
	public void clickSignIn() {
		linkSignIn.click();
		
	}
	
	public void writeWord(String palabra) {
		txtSearch.sendKeys(palabra);
		
	}
	
	public void clickSearch() {
		buttonSearch.click();
	}
	
	
	
	
	
}

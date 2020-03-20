package PageObjects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import junit.framework.Assert;

	@SuppressWarnings("deprecation")
	public class SinatraLoginPage extends BasePage {

	    public SinatraLoginPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
	    @FindBy(id="username")
		WebElement userName; // id =username
	    @FindBy(id="password")
	    WebElement password ;// id = password
	    //WebElement loginBtn ;// xpath = //input[@type = 'submit']
	    @FindBy(linkText="log in ")
	    WebElement loginLink;//xpath = //a[@href= '/login']
	   
	    public void loggIn(String user, String password){
	    
	    	WebElement userName = wait.until(ExpectedConditions.visibilityOf((WebElement) By.id(user)));
	    	userName.sendKeys(user);
	    	WebElement passWord = wait.until(ExpectedConditions.visibilityOf((WebElement) By.id(password)));
	    	passWord.sendKeys(password);
	    	wait.until(ExpectedConditions.visibilityOf(loginLink));
	    }

		public void verifyWelcomeMessage() {
			WebElement mensajeBienvenida = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
			Assert.assertEquals("You are now logged in as frank", mensajeBienvenida.getText());
		
		}

		public void clickLoginButton() {
			loginLink.click();
			
		}

	    
}

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SinatraHomePage extends BasePage {
	
		public SinatraHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
		@FindBy(linkText="log in ")
		WebElement linkLogin; //
		@FindBy(css="[src='/images/sinatra.jpg']")
		WebElement imagen;
		
	    public void navigate(String url) {
			// TODO Auto-generated method stub
			
		}

		public void verifyPage() {
			wait.until(ExpectedConditions.visibilityOf(linkLogin));
			wait.until(ExpectedConditions.visibilityOf(imagen));
			
		}

		public void clickLogin() {
			linkLogin.click();
			
		}

		public void verifyWelcomeMessage() {
			
		}
}

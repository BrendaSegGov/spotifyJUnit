package PageObjects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class SinatraLoginPage extends BasePage {

	    public SinatraLoginPage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}

		WebElement userName; // id =username
	    WebElement password ;// id = password
	    WebElement loginBtn ;// xpath = //input[@type = 'submit']
	    WebElement loginLnk; //xpath = //a[@href= '/login']

	   
	    public void loggIn(String user, String password){

	    }

		public void verifyWelcomeMessage() {
			// TODO Auto-generated method stub
			
		}

		public void clickLoginButton() {
			// TODO Auto-generated method stub
			
		}

	    
}

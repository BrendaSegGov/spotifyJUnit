package test;

import org.junit.Test;
import org.junit.runner.RunWith;

import PageObjects.SinatraHomePage;
import PageObjects.SinatraLoginPage;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@RunWith(JUnitParamsRunner.class)
public class ImdbJUnitPomTests extends BaseTest {

	@Test
	@FileParameters ("./data/imdbparameters.csv")
	public void testCorrectLogin(String url, String user,String password) {
		
		
		home.navigate(url);
		home.verifyPage();
		home.clickLogin();
		
		login.loggIn(user, password);
		login.clickLoginButton();
		
		home.verifyWelcomeMessage();
	}
	
}

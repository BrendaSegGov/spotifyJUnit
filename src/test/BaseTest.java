package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.SinatraHomePage;
import PageObjects.SinatraLoginPage;

public class BaseTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected SinatraHomePage home;// = new SinatraHomePage();
	protected SinatraLoginPage login; // = new SinatraLoginPage();
	
	@Before
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		home = new SinatraHomePage(driver);
		login = new SinatraLoginPage(driver);
	}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
	
	protected void navegarPagina(String url) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,  TimeUnit.MICROSECONDS);
		wait = new WebDriverWait(driver, 15);
		driver.get(url);
		
	}


	protected void loginSpotifyConFacebook(String correo, String password) {
		WebElement singIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button [contains(text(),'Log in')]")));
		singIn.click();
				//driver.findElement(By.linkText("Log in")).click();
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement botonFacebook = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a [@class='btn btn-block btn-facebook ng-binding']")));
		botonFacebook.click();
		
		WebElement campoEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		campoEmail.sendKeys(correo);
		
		WebElement campoPass = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
		campoPass.sendKeys(password);
		
		WebElement botonLogin = wait.until(ExpectedConditions.elementToBeClickable(By.name("login")));
		botonLogin.click();
		
	}
	protected void validarHomePage() {
		WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='user-widget-link']")));
		System.out.println("User Home Page Verified");
		
	}
	protected void buscarCancion(String songname) {
		// TODO Auto-generated method stub
		
		WebElement botonBuscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div [text()='Search']")));
		botonBuscar.click();
	
		WebElement barraBuscar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-testid='search-input']")));
		barraBuscar.sendKeys(songname);
	
	}
	protected void validarCancionTopResult(String songname) {
		// TODO Auto-generated method stub
		WebElement songname1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2 [text()='Top result']")));
		System.out.println("Song Verified\t" +songname);
	}
	
	
	protected void buscarArtista(String artistName) {
		buscarCancion(artistName); 
		
	}
	
	protected void validarArtistaTopResult(String artistName) {
		// TODO Auto-generated method stub
		
		WebElement selectArtist = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a [@title='"+artistName+"']")));//concatenar una variable en xpath
		selectArtist.click();
	}
	protected void followArtist() {
		// TODO Auto-generated method stub
		
		WebElement follow = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button [contains (text(), \"Follow\")]")));
		follow.click();
		
		System.out.println("Following");
	}
	protected void cerrarBrowser() {
		driver.quit();
		
	}
	
}

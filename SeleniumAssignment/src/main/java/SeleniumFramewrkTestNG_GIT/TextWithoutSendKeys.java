package SeleniumFramewrkTestNG_GIT;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextWithoutSendKeys {
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");	
	}
	
	@Test
	public void test() throws InterruptedException {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement name_email_phn = driver.findElement(By.name("username"));
		js.executeScript("arguments[0].value='aayu@gmail.com'",name_email_phn);
		Thread.sleep(5000);
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}

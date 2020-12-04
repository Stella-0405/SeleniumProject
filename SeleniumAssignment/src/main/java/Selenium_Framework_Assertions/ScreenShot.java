package Selenium_Framework_Assertions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {
	
	WebDriver driver;
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://api.jquery.com/dblclick/");
	}
	
	
	@Test
	public void takeScreenshot() throws IOException, InterruptedException {
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(screenshot,new File("C:\\Users\\STELLA\\Documents\\Screenshot.png"));
		Thread.sleep(5000);		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}


}

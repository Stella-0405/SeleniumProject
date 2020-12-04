package Selenium_Framwork_ExtentReport;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderAnnotation {
	WebDriver driver;
	String url = "https://www.google.com";
	
	@DataProvider(name="DP")
	public Object[][] function(){
		Object[][] data = new Object[2][1];
		data[0][0]="Selenium";
		data[1][0]="Java";
		return data;
	}
				

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}


	@Test(dataProvider = "DP")
	public void testData(String value) {
		WebElement text = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		text.sendKeys(value);
		Reporter.log("Value entered is:"+value);
		text.sendKeys(Keys.ENTER);
		Reporter.log("Searched results are displayed");
		System.out.println("Success:"+value);

	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}



}

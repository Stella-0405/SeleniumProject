package Selenium_Framwork_ExtentReport;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class CreateReport {
	WebDriver driver;
	String url = "https://www.google.co.in";
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	
	@Before
	public  void setUp()
	{
		htmlReporter = new ExtentHtmlReporter("./extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		test = extent.createTest("Google Search Test");

		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void extentReportsDemo() throws InterruptedException
	{
		test.log(Status.INFO, "Test started");
		driver.get(url);
		test.pass("Navigated to Google.com");
		
		driver.findElement(By.name("q")).sendKeys("FC Bayern");
		test.pass("Added text in search box");
		
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).submit();
		test.pass("Clicked Google Search button");		
		}
	

	@After
	public void endTest()
	{
		driver.quit();
		test.pass("Closed the browser");
		test.info("Test completed");
		extent.flush();
	}
}



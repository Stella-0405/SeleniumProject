package Selenium_Framework_Assertions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyPincode {
	
	WebDriver driver;
	
	@Before
	public void setup() throws Exception{
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://chennaiiq.com/chennai/pincode-by-name.php");
	}


	
	@Test
	  public void verifyPin() throws InterruptedException  {
		 WebElement f_location=driver.findElement(By.xpath("//table[@class='TBox']//tbody//tr[4]//td[2]"));
		 WebElement f_locpin=driver.findElement(By.xpath("//table[@class='TBox']//tbody//tr[4]//td[3]"));
		 WebElement s_location=driver.findElement(By.xpath("//table[@class='TBox']//tbody//tr[5]//td[2]"));
		 WebElement s_locpin=driver.findElement(By.xpath("//table[@class='TBox']//tbody//tr[5]//td[3]"));
		 Assert.assertNotEquals(f_locpin.getText().toString().trim(),s_locpin.getText().toString().trim());
		 System.out.println("Pin code of "+f_location.getText().toString().trim()+"is : "+f_locpin.getText().toString().trim());
		 System.out.println("Pin code of "+s_location.getText().toString().trim()+"is : "+s_locpin.getText().toString().trim());
		 System.out.println("So the pin code of 2 different locations are unique and not same");
	 }
	
	@After
	public void tearDown() throws Exception{
		driver.quit();
	}
}

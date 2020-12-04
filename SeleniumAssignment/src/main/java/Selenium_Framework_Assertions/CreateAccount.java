package Selenium_Framework_Assertions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccount {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signup");
	}
	
	@Test
	public void testCreatingAccout() {
		
		WebElement f_name = driver.findElement(By.id("firstName"));
		f_name.sendKeys("Arha");	
		String firstname = f_name.getAttribute("value");
		System.out.println("First name is:"+firstname);
		
		WebElement l_name = driver.findElement(By.id("lastName"));
		l_name.sendKeys("Anjali");	
		String lastname = l_name.getAttribute("value");
		System.out.println("Last name is:"+lastname);
		
		WebElement user_name = driver.findElement(By.id("username"));
		user_name.sendKeys("arhanjali043");	
		String userName = user_name.getAttribute("value");
		System.out.println("Username is:"+userName);
		
		WebElement password = driver.findElement(By.name("Passwd"));
		password.sendKeys("arha_123");	
		String psswd = password.getAttribute("value");
		System.out.println("Password is:"+psswd);
		
		WebElement confirmPassword = driver.findElement(By.name("ConfirmPasswd"));
		confirmPassword.sendKeys("arha_123");	
		String cpsswd = confirmPassword.getAttribute("value");
		System.out.println("Password is:"+cpsswd);
		
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/div/button/div[2]")).click();
		System.out.println("Account created successfully");
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

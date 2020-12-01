package SeleniumFramewrkTestNG_GIT;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BootStrapDropdown {
	WebDriver driver;	
	@Before
	public void setup() {		
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	}
	
	@Test
	public void testBootStrap() throws Exception{
		driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown-toggle')]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
		for (WebElement ele : list) {
			if(ele.getText().contains("HTML") || ele.getText().contains("CSS")) {
				ele.click();
			}
		}		
		List<WebElement> list1 = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
		for (WebElement elem : list1) {
			System.out.println(elem.getText());
			elem.click();
		}
		System.out.println("Elements selected:"+driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown-toggle')]")).getText());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}	

}

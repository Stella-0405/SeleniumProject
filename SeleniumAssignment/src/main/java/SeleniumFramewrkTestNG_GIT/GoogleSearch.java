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

public class GoogleSearch {

	WebDriver driver;	
	@Before
	public void setup() {		
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");

	}
	
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Size");
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		
		for (int i=0;i<list.size();i++) {
			String value = list.get(i).getText();
			System.out.println(value);
			
			if(value=="size reducer") {
				list.get(i).click();
				Thread.sleep(5000);
				break;
			}
		}
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

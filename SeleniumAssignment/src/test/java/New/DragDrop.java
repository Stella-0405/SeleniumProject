package New;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragDrop {	
	WebDriver driver;
	String url = "https://jqueryui.com/droppable/";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);			
	}
	
	@Test
	public void testDragDrop() throws InterruptedException {
		driver.switchTo().frame(0);
				
		WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).click().perform();	
		Thread.sleep(5000);		
	}
	
	@After
	public void tearDown() {
		driver.quit();		
	}
	

}

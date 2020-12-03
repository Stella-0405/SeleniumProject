package SeleniumFramewrkTestNG_GIT;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSize {
	WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
	}	
	
	@Test
	public void testSetSize() throws InterruptedException {
		
		System.out.println(driver.manage().window().getSize());
		Dimension dim = new Dimension(500,600);
		driver.manage().window().setSize(dim);	
		Thread.sleep(5000);
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}

}

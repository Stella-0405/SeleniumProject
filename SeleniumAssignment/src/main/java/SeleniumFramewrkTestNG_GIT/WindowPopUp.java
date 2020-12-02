package SeleniumFramewrkTestNG_GIT;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {
	
ChromeDriver driver;
	
	@Before
	public void setup() throws Exception{
		
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://popuptest.com/goodpopups.html");
	}
	
	@Test
	public void testPopUp() {
		driver.findElement(By.linkText("Good PopUp #1")).click();
		
		Set<String> windowhandle = driver.getWindowHandles();
		Iterator<String>popUpLinks = windowhandle.iterator();
		
		String parentWindow = popUpLinks.next();
		String childWindow = popUpLinks.next();
		
		driver.switchTo().window(childWindow);
		System.out.println("Child Window Title:" +driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		System.out.println("Parent Window Title:" +driver.getTitle());
		

		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}

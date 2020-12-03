package SeleniumFramewrkTestNG_GIT;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class ConfigFileReader {
	WebDriver driver;
	
	@Test
	public void testFileReader() throws IOException {
		Properties prop = new Properties();

		try {
			
			InputStream input = new FileInputStream("configs//config.properties");
			prop.load(input);
						
			System.out.println(prop.getProperty("driverPath"));
			System.out.println(prop.getProperty("implicitlyWait"));
			System.out.println(prop.getProperty("url"));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		driver.quit();		
	}

}

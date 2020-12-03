package SeleniumFramewrkTestNG_GIT;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	WebDriver driver;
	String url = "";
	HttpURLConnection huc = null;
    int respCode = 200;


	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Infosys\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.zlti.com/");		
	}

	@Test
	public void testBrokenLinks() {
		
		List<WebElement> lin=driver.findElements(By.tagName("a"));
		System.out.println("total links are"+lin.size());
		for(int i=0;i<lin.size();i++) {
			WebElement ele=lin.get(i);
			String url=ele.getAttribute("href");
			try {
				URL u=new URL(url);
				HttpURLConnection htpurlcnt=(HttpURLConnection)u.openConnection();
				htpurlcnt.setConnectTimeout(5000);
				htpurlcnt.connect();
				if(htpurlcnt.getResponseCode()==200) {
					System.out.println(url+" - "+ htpurlcnt.getResponseMessage());
				}
				if(htpurlcnt.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
					System.out.println(url+" - "+ htpurlcnt.getResponseMessage()+" - "+HttpURLConnection.HTTP_NOT_FOUND);
				}
			}catch(Exception e) {
				System.out.println(url+" - "+" - "+HttpURLConnection.HTTP_NOT_FOUND);
			}
		}
	 }

		
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		System.out.println("Total links are:"+links.size());
//		Iterator<WebElement> it = links.iterator();
//
//		while(it.hasNext()){
//			url = it.next().getAttribute("href");
//			System.out.println(url);
//			if(url == null || url.isEmpty()){
//				System.out.println("URL is either not configured for anchor tag or it is empty");
//				continue;
//			}
//			if(!url.startsWith("https://www.zlti.com/")){
//				System.out.println("URL belongs to another domain, skipping it.");
//				continue;
//			}
//			try {
//				huc = (HttpURLConnection)(new URL(url).openConnection());
//
//				huc.setRequestMethod("HEAD");
//
//				huc.connect();
//
//				respCode = huc.getResponseCode();
//
//				if(respCode >= 400){
//					System.out.println(url+" is a broken link");
//				}
//				else{
//					System.out.println(url+" is a valid link");
//				}
//
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}

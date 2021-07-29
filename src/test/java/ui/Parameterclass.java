package ui;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Parameterclass {
		
@Test
	public void Sonar() {
	
	System.out.println("Reading username from jenkins");
	String username = System.getProperty("username");
	System.out.println("Reading password from jenkins");
	String password = System.getProperty("password");
	System.out.println("Reading Sonar url from jenkins");
	String sonarurl = System.getProperty("sonarurl");
	//System.out.println(username);
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		options.addArguments("window-size=1280,720");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options); 
		
		
		
		driver.get("https://sonar.manulife.com/sessions/new");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		//driver.findElement(By.xpath("//input[@class='button']")).click();
		//driver.findElement(By.xpath("//button[@title='Log in']")).click();
		//driver.findElement(By.xpath("//button[@class='button']")).click();
		WebElement btn_Login=driver.findElement(By.xpath("//button[normalize-space(text())='Log in']"));
                btn_Login.click();
		//WebElement login = driver.findElement(By.type("submit"));
		//login.click();			
       		 System.out.println("Login Done with Click");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.get(sonarurl);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//screenshots
		TakesScreenshot scrShot =((TakesScreenshot)driver);

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
               File DestFile=new File("sonar-screenshot.png");
                try {
					FileUtils.copyFile(SrcFile, DestFile);
					System.out.println("**********Sonar_Screenshot_Captured**********");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		driver.quit();
	}
  /*  @Test
	public void Fortify() {
    	
    	System.out.println("reading username from jenkins");
    	String username = System.getProperty("username");
    	System.out.println("reading password from jenkins");
    	String password = System.getProperty("password");
    	System.out.println("reading fortify url from jenkins");
    	String fortifyurl = System.getProperty("fortifyurl");
    	//System.out.println(username);
    	
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	
    		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		//options.addArguments("--headless");
		options.addArguments("window-size=1400,800");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options); 
    	
    	//ChromeDriver driver = new ChromeDriver();
    	
    	
    	//browser xpaths
    	driver.get(fortifyurl);
    	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    	//screenshots
    	TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
       File DestFile=new File("Fortify-screenshot.png");
        try {
			FileUtils.copyFile(SrcFile, DestFile);
			System.out.println("**********Fortify_Screenshot_Captured**********");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
	}
    @Test
    public void Syn() {
    	
    	System.out.println("reading username from jenkins");
    	String username = System.getProperty("username");
    	System.out.println("reading password from jenkins");
    	String password = System.getProperty("password");
    	System.out.println("reading Syn url from jenkins");
    	String synurl = System.getProperty("synurl");
    	//System.out.println(username);
    	
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	
    		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		//options.addArguments("--headless");
		options.addArguments("window-size=1400,800");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options); 
    	
    	
    	//browser xpaths here
    	driver.get(synurl);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    	
    	//screenshots
    	TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
       File DestFile=new File("Sync-screenshot.png");
        try {
			FileUtils.copyFile(SrcFile, DestFile);
			System.out.println("**********Syn_Screenshot_Captured**********");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
	}
*/	
	
}

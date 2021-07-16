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

public class SFSclass {
	String username = null;
	String password = null;
	
@Test
	public void Sonar() {
		
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
		//for config.xml
		String url = null;
		String path=System.getProperty("user.dir");
		 try (InputStream input = new FileInputStream(path+"/config.properties")) {
	            Properties prop = new Properties();
	        // load a properties file
	        prop.load(input);
	        username = prop.getProperty("username");
	        password = prop.getProperty("password");
            url = prop.getProperty("url");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		 //upto config.xml
		 //browser xpaths
		//driver.get("https://github.com/babusatti/sattibaburepository");
		driver.get(url);
		//driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		
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
    @Test
	public void Fortify() {
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
    	
    	String url2 = null;
		String path=System.getProperty("user.dir");
		 try (InputStream input = new FileInputStream(path+"/config.properties")) {
	            Properties prop = new Properties();
	        // load a properties file
	        prop.load(input);
	        username = prop.getProperty("username");
	        password = prop.getProperty("password");
            url2 = prop.getProperty("url2");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
    	//browser xpaths
    	driver.get(url2);
    	
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
    	
    	String url3 = null;
		String path=System.getProperty("user.dir");
		 try (InputStream input = new FileInputStream(path+"/config.properties")) {
	            Properties prop = new Properties();
	        // load a properties file
	        prop.load(input);
	        username = prop.getProperty("username");
	        password = prop.getProperty("password");
            url3 = prop.getProperty("url3");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
    	//browser xpaths here
    	driver.get(url3);
    	
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
	
	
}

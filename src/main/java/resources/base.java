package resources;

import java.io.File;



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		// TODO Auto-generated method stub

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/Data.properties");
		prop.load(fis);

		// running from system for jenkins optimizing
		String browserName = System.getProperty("browser");

		// String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "/Users/dolly/eclipse-workspace/libs/chromedriver");
			ChromeOptions options = new ChromeOptions();
			
			if (browserName.contains("headless")) 
			{
				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);
		} 
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/dolly/eclipse-workspace/libs/geckodriver");

			driver = new FirefoxDriver();
		} 
		else if (browserName.equals("Safari")) {

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public void takeScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		// store screenshot in any virtual file
		File source = ts.getScreenshotAs(OutputType.FILE);
		// user.dir is the current project directory
		String destinationFile = System.getProperty(("user.dir") + "reports" + testCaseName + ".png");
		// fileUtils will copy the file from source to my directory
		FileUtils.copyFile(source, new File(destinationFile));

	}
}

package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
//import java.sql.Date;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//Appenders 
//Where we generate logs console/file.

//Loggers
//What type of logs to generate
//Trace-Debug-info-Warn-Error-Flatal-Off


public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	
	public Properties p;
	
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})

	@Parameters({"os","browser"})

	public void setup(String os, String br) throws IOException

	{

		//Loading config.properties file

		FileReader file=new FileReader("./src//test//resources//config.properties");

		p=new Properties();

		p.load(file);

		logger=LogManager.getLogger(this.getClass());  //lOG4J2

		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))

		{

			DesiredCapabilities capabilities=new DesiredCapabilities();

			//os

			if(os.equalsIgnoreCase("windows"))

			{

				capabilities.setPlatform(Platform.WINDOWS);

			}

			else if (os.equalsIgnoreCase("mac"))

			{

				capabilities.setPlatform(Platform.MAC);

			}

			else if (os.equalsIgnoreCase("linux"))

			{

				capabilities.setPlatform(Platform.LINUX);

			}
			else

			{

				System.out.println("No matching os");

				return;

			}

			//browser

			switch(br.toLowerCase())

			{

			case "chrome": capabilities.setBrowserName("chrome"); break;

			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			
			case "firefox": capabilities.setBrowserName("firefox"); break;
			
			default: System.out.println("No matching browser"); return;

			}

			driver=new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);

		}


		if(p.getProperty("execution_env").equalsIgnoreCase("local"))

		{
 
			switch(br.toLowerCase())

			{

			case "chrome" : driver=new ChromeDriver(); break;

			case "edge" : driver=new EdgeDriver(); break;

			case "firefox": driver=new FirefoxDriver(); break;

			default : System.out.println("Invalid browser name.."); return;

			}

		}


		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL")); // reading url from properties file.

		driver.manage().window().maximize();

	}

 
		
	/*
	 * switch(br.toLowerCase()) { case "chrome": driver=new ChromeDriver(); break;
	 * case "edge": driver=new EdgeDriver(); break; default:
	 * System.out.println("No matching browser.."); return; } //driver=new
	 * ChromeDriver();
	 */ /*
		 * driver.manage().deleteAllCookies();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * driver.get(p.getProperty("appURL"));
		 * //driver.get("https://tutorialsninja.com/demo/index.php?route=account/login")
		 * ; driver.manage().window().maximize(); }
		 */
	@AfterClass (groups= {"Master","Sanity","Regression"})
	public void tearDown() { 
		driver. close(); 
		}
	 
	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}

	public String LoginEmail() {
		return p.getProperty("LoginUsername");
		//return p.getProperty(null);
	}
	public String LoginPassword() {
		return p.getProperty("LoginPassword");
	}
	
	public String captureScreen(String tname) throws IOException {
		 
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		if (driver == null) {
		    throw new RuntimeException("Driver is NULL");
		}
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
 
	}
	
	
}


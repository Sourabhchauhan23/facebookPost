package base;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;
	public Logger log;
	
	public String testSuiteName;
	public String testName;
	public String testMethodName;
	
	
	/* Creating WebDriver instance */
	
	@BeforeMethod
	public void setup(Method method, ITestContext ctx) {
		
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);
		log.info("Opening Browser");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
	}
	
	/* Closing WebDriver */
	
	@AfterMethod
	public void tearDown() {		
		driver.close();
		driver.quit();
		log.info("Closing driver");
	}

}
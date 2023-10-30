package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {

	public static WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeSuite
	public void beforeSuite(String browserNm, String url) {
		if (browserNm.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		
		else if (browserNm.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browserNm.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "resources/edgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();


	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
}

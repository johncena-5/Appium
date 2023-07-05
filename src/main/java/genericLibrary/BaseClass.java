package genericLibrary;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	PropertyLibrary pLib;
	WebDriverLibrary wLib;
	ExcelLibrary eLib;
	protected WebDriver driver;
	long time;

	@BeforeSuite
	public void suiteConfig() {

	}

	@BeforeTest
	public void testConfig() {

	}

	@Parameters("browser")
	@BeforeClass
	public void classConfig(String browser) {
		pLib = new PropertyLibrary();
		wLib = new WebDriverLibrary();
		eLib = new ExcelLibrary();
		time = Long.parseLong(pLib.fetchDataFromPropertyFile("time"));
		driver = wLib.lauchBrowser(browser, pLib.fetchDataFromPropertyFile("url"), time);

	}

	@BeforeMethod
	public void tearDownConfig() {

	}

	@AfterMethod
	public void tearDownMethod() {

	}

	@AfterClass
	public void classTearDown() {
		wLib.closeDriver();
	}
//	@AfterTest
//	@AfterSuite

}
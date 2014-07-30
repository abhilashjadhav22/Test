package Test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Platform;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestContactUs {

	WebDriver driver;

	// right now added only two browsers for cross browser testing as there are restriction on parallel cross browser testing is max 3 browsers
	@DataProvider(name = "hardCodedBrowsers", parallel = true)
	public static Object[][] sauceBrowserDataProvider(Method testMethod) {
		return new Object[][]{
				new Object[]{"firefox", "31.0", "windows"},
				new Object[]{"chrome", "36.0", "windows"}
		};
	}

	private WebDriver createDriver(String browser, String version, String os) throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browser);
		capabilities.setCapability("version", version);
		capabilities.setCapability("platform",Platform.extractFromSysProperty(os));
		this.driver = new RemoteWebDriver(
				new URL("http://abhilash_jadhav22:9f3a2e20-5b21-4ee9-bd5f-8fd34079ac18@ondemand.saucelabs.com:80/wd/hub"),
				capabilities);
		return this.driver;
	}

	@Test(dataProvider = "hardCodedBrowsers")
	public void Contact_Us_with_Blank_Email_and_Desciption(String browser, String version, String os) throws Exception {

		WebDriver driver = createDriver(browser, version, os);

		driver.get("http://test.helpshift.com");
		click(By.id("new-issue"));

		type(By.id("user-name"),"Abhilash");
		click(By.className("modal-submit-button"));

		List<WebElement> list = driver.findElements(By.className("error-msg"));

		assertTrue("Shows warning for required email", list.get(0).getText().equals( "Email is a required field"));
		assertTrue("Shows warning for required description field", list.get(1).getText().equals( "Problem description is a required field"));

		driver.quit();
	}

	@Test(dataProvider = "hardCodedBrowsers")
	public void Contact_Page_with_valid_email_and_description(String browser, String version, String os) throws Exception {

		WebDriver driver = createDriver(browser, version, os);

		driver.get("http://test.helpshift.com");
		click(By.id("new-issue"));

		type(By.id("user-name"),"Abhilash");
		type(By.id("user-email"),"aaa@aaa.com");
		type(By.id("user-issue"),"Hello World...!");		
		click(By.className("modal-submit-button"));

		assertTrue("Shows message received.", driver.findElement(By.className("message-wrapper")).getText().equals("Thanks for contacting us. Your message was received."));

		driver.quit();	
	}

	@Test(dataProvider = "hardCodedBrowsers")
	public void Contact_Page_with_blank_email_and_valid_description(String browser, String version, String os) throws Exception {

		WebDriver driver = createDriver(browser, version, os);

		driver.get("http://test.helpshift.com");
		click(By.id("new-issue"));

		type(By.id("user-name"),"Abhilash");
		type(By.id("user-issue"),"Hello World...!");		
		click(By.className("modal-submit-button"));

		List<WebElement> list = driver.findElements(By.className("error-msg"));

		assertTrue("Shows warning for required email", list.get(0).getText().equals( "Email is a required field"));

		driver.quit();	
	}

	@Test(dataProvider = "hardCodedBrowsers")
	public void Contact_Page_with_Invalid_email_and_Valid_description(String browser, String version, String os) throws Exception {

		WebDriver driver = createDriver(browser, version, os);

		driver.get("http://test.helpshift.com");
		click(By.id("new-issue"));

		type(By.id("user-name"),"Abhilash");
		type(By.id("user-email"),"aaa");
		type(By.id("user-issue"),"Hello World...!");		
		click(By.className("modal-submit-button"));

		List<WebElement> list = driver.findElements(By.className("error-msg"));

		assertTrue("Shows warning for valid email", list.get(0).getText().equals("Please enter a valid email"));

		driver.quit();	
	}

	@Test(dataProvider = "hardCodedBrowsers")
	public void Contact_Page_with_valid_email_and_blank_description(String browser, String version, String os) throws Exception {

		WebDriver driver = createDriver(browser, version, os);

		driver.get("http://test.helpshift.com");
		click(By.id("new-issue"));

		type(By.id("user-name"),"Abhilash");
		type(By.id("user-email"),"aaa@aaa.com");
		click(By.className("modal-submit-button"));

		List<WebElement> list = driver.findElements(By.className("error-msg"));

		assertTrue("Shows warning for required description field", list.get(1).getText().equals( "Problem description is a required field"));

		driver.quit();	
	}

	@Test(dataProvider = "hardCodedBrowsers")
	public void Contact_Page_with_Invalid_email_and_blank_description(String browser, String version, String os) throws Exception {

		WebDriver driver = createDriver(browser, version, os);

		driver.get("http://test.helpshift.com");
		click(By.id("new-issue"));

		type(By.id("user-name"),"Abhilash");
		type(By.id("user-email"),"aaa");
		click(By.className("modal-submit-button"));

		List<WebElement> list = driver.findElements(By.className("error-msg"));

		assertTrue("Shows warning for valid email", list.get(0).getText().equals("Please enter a valid email"));
		assertTrue("Shows warning for required description field", list.get(1).getText().equals( "Problem description is a required field"));

		driver.quit();	
	}

	public void type(By by, String value)	
	{
		driver.findElement(by).sendKeys(value);
	}

	public void click(By by)
	{
		driver.findElement(by).click();
	}

}
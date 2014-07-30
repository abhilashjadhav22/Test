package Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestContactUs {
	
	WebDriver driver;
	String baseUrl;
	
	@Test
	public void TestSuccess() throws IOException, WebDriverException
	{
		//In this test, providing valid email & valid description
		driver=new FirefoxDriver();
		driver.get("http://test.helpshift.com");
		assertTrue("Wrong URL", driver.getCurrentUrl().equals("http://test.helpshift.com/a/ios-test/"));
		
		click(By.id("new-issue"));
		assertTrue("Wrong URL", driver.getCurrentUrl().equals("http://test.helpshift.com/a/ios-test/?contact=1"));
		
		type(By.id("user-name"),"Abhilash");
		type(By.id("user-email"),"aaa@aaa.com");
		type(By.id("user-issue"),"Hello World...!");
		
		click(By.className("modal-submit-button"));
		
		List<WebElement> list = driver.findElements(By.className("error-msg"));
		for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equals("Please enter a valid email"))
            {
            	assertFalse("Please enter a valid email", list.get(i).getText().equals("Please enter a valid email"));
            }
            else if(list.get(i).getText().equals("Email is a required field"))
            {
            	assertFalse("Email is a required field", list.get(i).getText().equals( "Email is a required field"));
            }
            else if(list.get(i).getText().equals("Problem description is a required field"))
            {
            	assertFalse("Problem description is a required field", list.get(i).getText().equals( "Problem description is a required field"));
            }
        }
		
		driver.quit();	
	}
	
	@Test
	public void TestFail1() throws IOException, WebDriverException, UnknownError
	{
		//In this test, we are providing blank email & valid description
		driver=new FirefoxDriver();
		driver.get("http://test.helpshift.com");
			
		click(By.id("new-issue"));
		assertTrue("Wrong URL", driver.getCurrentUrl().equals("http://test.helpshift.com/a/ios-test/?contact=1"));
		
		type(By.id("user-name"),"Abhilash");
		//type(By.id("user-email"),"aaa@aa2.com");
		type(By.id("user-issue"),"Hello World...!");
		
		click(By.className("modal-submit-button"));
		
		List<WebElement> list = driver.findElements(By.className("error-msg"));
		for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equals("Please enter a valid email"))
            {
            	assertFalse("Please enter a valid email", list.get(i).getText().equals("Please enter a valid email"));
            }
            else if(list.get(i).getText().equals("Email is a required field"))
            {
            	assertFalse("Email is a required field", list.get(i).getText().equals( "Email is a required field"));
            }
            else if(list.get(i).getText().equals("Problem description is a required field"))
            {
            	assertFalse("Problem description is a required field", list.get(i).getText().equals( "Problem description is a required field"));
            }
            
        }
		
		driver.quit();
		
	}
	
	@Test
	public void TestFail2() throws IOException, WebDriverException, UnknownError
	{
		//In this test, we are providing invalid email & valid description
		driver=new FirefoxDriver();
		driver.get("http://test.helpshift.com");
	
		click(By.id("new-issue"));
		assertTrue("Wrong URL", driver.getCurrentUrl().equals("http://test.helpshift.com/a/ios-test/?contact=1"));
		
		type(By.id("user-name"),"Abhilash");
		type(By.id("user-email"),"aaa");
		type(By.id("user-issue"),"Hello World...!");
		
		click(By.className("modal-submit-button"));
		
		List<WebElement> list = driver.findElements(By.className("error-msg"));
		for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equals("Please enter a valid email"))
            {
            	assertFalse("Please enter a valid email", list.get(i).getText().equals("Please enter a valid email"));
            }
            else if(list.get(i).getText().equals("Email is a required field"))
            {
            	assertFalse("Email is a required field", list.get(i).getText().equals( "Email is a required field"));
            }
            else if(list.get(i).getText().equals("Problem description is a required field"))
            {
            	assertFalse("Problem description is a required field", list.get(i).getText().equals( "Problem description is a required field"));
            }
            
        }
		
		driver.quit();
		
	}
	
	@Test
	public void TestFail3() throws IOException, WebDriverException, UnknownError
	{
		//In this test, we are providing valid email & blank description
		driver=new FirefoxDriver();
		driver.get("http://test.helpshift.com");
		
		click(By.id("new-issue"));
		assertTrue("Wrong URL", driver.getCurrentUrl().equals("http://test.helpshift.com/a/ios-test/?contact=1"));
		
		type(By.id("user-name"),"Abhilash");
		type(By.id("user-email"),"aaa@aaa.com");
		//type(By.id("user-issue"),"Hello World...!");
		
		click(By.className("modal-submit-button"));
		
		List<WebElement> list = driver.findElements(By.className("error-msg"));
		for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equals("Please enter a valid email"))
            {
            	assertFalse("Please enter a valid email", list.get(i).getText().equals("Please enter a valid email"));
            }
            else if(list.get(i).getText().equals("Email is a required field"))
            {
            	assertFalse("Email is a required field", list.get(i).getText().equals( "Email is a required field"));
            }
            else if(list.get(i).getText().equals("Problem description is a required field"))
            {
            	assertFalse("Problem description is a required field", list.get(i).getText().equals( "Problem description is a required field"));
            }
            
        }
		
		driver.quit();
		
	}
	
	@Test
	public void TestFail4() throws IOException, WebDriverException, UnknownError
	{
		//In this test, we are providing blank email & blank description
		driver=new FirefoxDriver();
		driver.get("http://test.helpshift.com");
		
		click(By.id("new-issue"));
		assertTrue("Wrong URL", driver.getCurrentUrl().equals("http://test.helpshift.com/a/ios-test/?contact=1"));
		
		type(By.id("user-name"),"Abhilash");
		//type(By.id("user-email"),"aaa@aaa.com");
		//type(By.id("user-issue"),"Hello World...!");
		
		click(By.className("modal-submit-button"));
		
		List<WebElement> list = driver.findElements(By.className("error-msg"));
		
		assertFalse("Please enter a valid email", list.get(0).getText().equals("Please enter a valid email"));
		assertFalse("Email is a required field", list.get(0).getText().equals( "Email is a required field"));
		assertFalse("Problem description is a required field", list.get(1).getText().equals( "Problem description is a required field"));
		
		driver.quit();																										
		
	}
	
	@Test
	public void TestFail5() throws IOException, WebDriverException, UnknownError
	{
		//In this test, we are providing invalid email & valid description
		driver=new FirefoxDriver();
		driver.get("http://test.helpshift.com");

		click(By.id("new-issue"));
		assertTrue("Wrong URL", driver.getCurrentUrl().equals("http://test.helpshift.com/a/ios-test/?contact=1"));
		
		type(By.id("user-name"),"Abhilash");
		type(By.id("user-email"),"aaa");
		//type(By.id("user-issue"),"Hello World...!");
		
		click(By.className("modal-submit-button"));
		
		List<WebElement> list = driver.findElements(By.className("error-msg"));
		for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equals("Please enter a valid email"))
            {
            	assertFalse("Please enter a valid email", list.get(i).getText().equals("Please enter a valid email"));
            }
            else if(list.get(i).getText().equals("Email is a required field"))
            {
            	assertFalse("Email is a required field", list.get(i).getText().equals( "Email is a required field"));
            }
            else if(list.get(i).getText().equals("Problem description is a required field"))
            {
            	assertFalse("Problem description is a required field", list.get(i).getText().equals( "Problem description is a required field"));
            }
            
        }
		
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
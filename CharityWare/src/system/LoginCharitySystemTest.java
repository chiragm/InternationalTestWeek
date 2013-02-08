package system;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestBase;
import com.thoughtworks.selenium.Selenium;
public class LoginCharitySystemTest extends SeleneseTestBase {
	
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		driver = new HtmlUnitDriver();
		driver.get("http://localhost:8080/CharityWare/login.jsp");
	}

	@Test
	public void testcLogin() throws Exception {
//		driver = new HtmlUnitDriver();
		driver.get("http://localhost:8080/CharityWare/login.jsp");
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("rcadmin");
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("open");
		WebElement button  = driver.findElement(By.id("button1"));
		button.click();
		List<WebElement> tabs = driver.findElements(By.xpath("//div[@id='tabs']/*/*"));
		assertEquals(5, tabs.size());
		
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

		

}

package system;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class CharityFormPopTest {
	
	WebDriver driver;
	
	@Before
	public void init() {
		driver = new HtmlUnitDriver();
		driver.get("http://localhost:8080/CharityWare/login.jsp");
	}
	
	
	@Test
	public void execute() {
		driver.get("http://localhost:8080/CharityWare/login.jsp");
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("rcadmin");
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys("open");
		WebElement button  = driver.findElement(By.id("button1"));
		button.click();
		WebElement dlist = driver.findElement(By.id("myformslist"));
		Select selection = new Select(dlist);
		assertNotNull(selection);
		//		selection.selectByVisibleText("Personal Information");

	}
	
	
	@After
	public void close() {
		driver = null;
	}

}

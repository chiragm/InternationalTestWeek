package system;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxUclAdminNoSubmit {

	FirefoxDriver driver;
		
		@Before
		public void setUp() throws Exception {
			driver = new FirefoxDriver();
			driver.get("http://localhost:8080/CharityWare/login.jsp");
		}

		@Test
		public void test() throws Exception {
			//driver.get("http://localhost:8080/CharityWare/login.jsp");
			
			// login
			WebElement username = driver.findElement(By.id("txtUsername"));
			username.sendKeys("ucladmin");
			WebElement password = driver.findElement(By.id("txtPassword"));
			password.sendKeys("open");
			WebElement button  = driver.findElement(By.id("button1"));
			button.click();
			
			
			
			WebElement firstApproveButton = driver.findElement(By.xpath("//*[@id=\"content_1\"]/form/table/tbody/tr[2]/td[6]/input[1]"));
			firstApproveButton.click();

			WebElement submit = driver.findElement(By.className("contactSubmit_dummy"));
			assertEquals("input", submit.getTagName());
		}
		
		
		


}

package system;
import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;

	//import org.junit.Test;


public class FireFoxUclAdminRequestsTest {
	
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
			
			
			
			List<WebElement> raws = driver.findElements(By.xpath("//*[@id='content_1']/form/table/tbody/tr"));
			// Validator: whether #raws is 4 + 1(header)
			assertEquals(5, raws.size());
		}
		
		
		

	

}

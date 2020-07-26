package co.in.gmail.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginToGmail 
{
	public WebDriver driver = null;
	@Test
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\CICD_Selenium\\Gmail\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.gmail.com");
		 driver.manage().window().maximize();
		 WebElement email = driver.findElement(By.id("identifierId"));
		 email.sendKeys("edurekaseleniumtest@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.name("password")).sendKeys("Password@12345$");
		driver.findElement(By.id("identifierNext")).click();
		
		String title =driver.getTitle();
		if(title.contains("Inbox"))
		{
			Reporter.log("Login successful", true);
		}
		else
			Reporter.log("Login failed", true);
	}

}

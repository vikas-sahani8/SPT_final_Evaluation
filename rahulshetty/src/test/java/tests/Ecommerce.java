package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ecommerce {
	
	WebDriver driver; 
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://sso.teachable.com/secure/9521/identity/login/password?force=true");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test
	public void addItemToCart() {
		
		driver.findElement(By.id("email")).sendKeys("vikisvg19@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Vikas1234");
		driver.findElement(By.xpath("//input[@type = 'submit' and @value = 'Log in']")).click();
		driver.findElement(By.className("navbar-current-user")).isDisplayed();
		WebElement searchbox =  driver.findElement(By.xpath("//input[@id = 'search-courses']"));
		searchbox.click();
		searchbox.sendKeys("Zara Coat 3");
		driver.findElement(By.xpath("//button[@id ='search-course-button']")).click();
		driver.findElement(By.className("course-box-image")).click();
		driver.findElement(By.xpath("//button[@id ='enroll-button']")).click();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Search {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
	}
	
	
	
	
	// --------------- Test Case 1---------------
	// -------Search with valid product----------
	@Test(priority = 1)
	public void sr_ValidProduct() {

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("HP");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		boolean product = driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).isDisplayed();
		Assert.assertTrue(product);

	}

	// --------------- Test Case 2---------------
	// -------Search with Invalid product----------
	@Test(priority = 2, groups = {"smoke"})
	public void sr_InvalidProduct() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("honda");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		String noproduct = driver
				.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]"))
				.getText();
		Assert.assertEquals(noproduct, "There is no product that matches the search criteria.");
	}

	// --------------- Test Case 3---------------
	// -------Search with NO product----------
	@Test(priority = 3)
	public void sr_NOProduct() {

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		String noproduct = driver
				.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]"))
				.getText();
		Assert.assertEquals(noproduct, "There is no product that matches the search criteria.");

	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	

}

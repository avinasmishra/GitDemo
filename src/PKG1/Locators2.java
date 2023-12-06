package PKG1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class Locators2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
			
		String password = getPassword(driver); // calling getPassword method
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Avinash");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(2000);
		
		String actualText = driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText();
		System.out.println(actualText);
		//comparing actual or expected values are same or not using Assert function
		Assert.assertEquals(actualText,"You are successfully logged in.");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
	
	//instead of hard code password we create a method and extract from it how?
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();		
		String passText= driver.findElement(By.cssSelector("p.infoMsg")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.- from here we have to extract rahulshettyacademy as password how
		//using split method to extract the password from string
		String[] passAray = passText.split("'");
		String[] passAray2 = passAray[1].split("'");
		String pass = passAray2[0];
		return pass;
		
		
		
		
	}

}

package PKG1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Avinash");
		driver.findElement(By.name("inputPassword")).sendKeys("Avi123");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		String msg = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(msg);
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@rsa.com");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9876543210");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();		
		String msg1= driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println(msg1);
		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();
		
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Avinash");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		
		String extectedTitle = "Rahul Shetty Academy - Login page";
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(extectedTitle))
		{
			System.out.println("Successful Login");
		}
		else
		{
			System.out.println("Title is not matching");
		}
		
		driver.close();
		
	}

}

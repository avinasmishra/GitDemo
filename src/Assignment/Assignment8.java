package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\SeleniumTraining\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
	driver.findElement(By.id("autocomplete")).sendKeys("ind");
	Thread.sleep(2000);
	driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
	
	}

}

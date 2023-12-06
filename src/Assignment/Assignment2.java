package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.findElement(By.name("name")).sendKeys("Avinash Kumar");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Avinash123@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Avi@123456");
		driver.findElement(By.cssSelector("input#exampleCheck1")).click();
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select genderDP = new Select(dropdown);
		genderDP.selectByVisibleText("Male");
		driver.findElement(By.cssSelector("#inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("20-01-2001");
		driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		// System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

	}

}

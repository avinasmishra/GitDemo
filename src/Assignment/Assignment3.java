package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));

		//(username is rahulshettyacademy and Password is learning)
		String completeText = driver.findElement(By.cssSelector("p.text-center.text-white")).getText();
		String[] splitedText = completeText.split(" ");
		String uname =splitedText[2].trim();
		String[] password = splitedText[6].split("\\)");
		String pwd = password[0].trim();

		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.cssSelector("input#password")).sendKeys(pwd);

		driver.findElement(By.xpath("//input[@value='user']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#okayBtn")));
		driver.findElement(By.cssSelector("button#okayBtn")).click();

		WebElement dp = driver.findElement(By.cssSelector("select[data-style='btn-info']"));
		Select sc =new Select(dp);
		sc.selectByVisibleText("Consultant");

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		/*
		String expectedText ="ProtoCommerce Home";
		String actualText = driver.findElement(By.xpath("//a[contains(text(),'ProtoCommerce Home')]")).getText();
		Assert.assertEquals(actualText, expectedText);
		 *//*
		List<WebElement> phones = driver.findElements(By.xpath("//div[@class='card-footer']/button"));

		for(int i=0;i<phones.size();i++)
		{
			phones.get(i).click();		
		}
		  */
		List<WebElement> phones = driver.findElements(By.cssSelector("h4.card-title"));

		for(int i=0;i<phones.size();i++)
		{
			driver.findElements(By.xpath("//button[contains(@class,'btn')]")).get(i).click();

		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

	}

}

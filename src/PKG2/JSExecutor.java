package PKG2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JSExecutor {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\SeleniumTraining\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		//toscroll table inside window
		js.executeScript("document.querySelector('.tableFixHead').scrollBy(0,500)");
		
		List<WebElement> values = driver.findElements(By.xpath("//div[@class = 'tableFixHead']/table/tbody/tr/td[4]"));
		int sum=0;
		
		for(int i=0;i<values.size();i++)
		{
			String amt = values.get(i).getText();
			//convert string to integer
			sum = sum + Integer.parseInt(amt);		
		}
		//System.out.println(sum);
		WebElement element = driver.findElement(By.cssSelector("div[class = 'totalAmount']"));
		String txt = element.getText();
		String trim = txt.split(":")[1].trim();
		int total =Integer.parseInt(trim);
		Assert.assertEquals(sum, total);
		
		
		
	}

}

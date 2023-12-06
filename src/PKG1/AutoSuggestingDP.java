package PKG1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestingDP {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		//iterate
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("india"))
			{
				option.click();
				break;
			}
		}
		
		/*
		driver.get("https://www.google.com/");
		
		driver.findElement(By.id("APjFqb")).sendKeys("selenium");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
		
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("selenium python"))
			{
				option.click();
				break;
			}
		}*/
	}

}

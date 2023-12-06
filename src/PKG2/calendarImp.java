package PKG2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendarImp {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinash\\SeleniumTraining\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		// Scroll the Page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1100)");
		Thread.sleep(2000);

		WebElement date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));
		//js.executeScript("arguments[0].scrollIntoView(true);", date);
		date.click();

		while(!driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("October"))
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}
		//grab the common attributes for day then put into list and iterate
		Thread.sleep(2000);
		List<WebElement> days = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		int count = days.size();

		for(int i=0;i<count;i++)
		{
			String dates = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
			if(dates.contains("29"))
			{
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				break;
			}
		}

	}

}

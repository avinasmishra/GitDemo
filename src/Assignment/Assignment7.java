package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avinash\\SeleniumTraining\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		
		WebElement table = driver.findElement(By.xpath("//table[@id='product' and @name='courses']"));
		
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		int rows = tableRows.size();
		List<WebElement> tableCols = table.findElements(By.tagName("th"));
		int cols = tableCols.size();
		System.out.println("Total Rows: " + rows);
		System.out.println("Total Cols: " + cols);
				
		System.out.println(tableRows.get(2).getText());
				
	}

}

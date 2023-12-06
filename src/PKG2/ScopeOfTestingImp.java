package PKG2;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScopeOfTestingImp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinash\\SeleniumTraining\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		//1. Give me total link count no. of link present in page
		int linkCount = driver.findElements(By.tagName("a")).size();
		System.out.println("Total link Count :"+ linkCount);

		//2. Give me link count in only footer section

		System.out.println("Link Count for Footer Section : "+driver.findElement(By.id("gf-BIG")).findElements(By.tagName("a")).size());

		//3.Give me count of particular column

		WebElement partColumn = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr[1]/td[1]/ul"));
		System.out.println("link Count for Particular Column : " + partColumn.findElements(By.tagName("a")).size());

		//4. click on each link in the column and check if page are opening
		
		/*
		Actions act= new Actions(driver);
		for(int i=1;i<partColumn.findElements(By.tagName("a")).size();i++)
		{
			act.moveToElement(partColumn.findElements(By.tagName("a")).get(i)).keyDown(Keys.CONTROL).click().build().perform();
		}
		*/
		
		for(int i=1;i<partColumn.findElements(By.tagName("a")).size();i++)
		{
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			partColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			
		}
		
			Set<String>windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
	
	}

}

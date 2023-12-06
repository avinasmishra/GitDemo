package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='PAT']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
		//using parent-child traverse- either use 18 line or 20th line
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
	
		//select current date //class original= [ui-state-default ui-state-highlight ui-state-hover]
		//if we are using cssSelector and if class attribute value contains space between the word remove the space and put .(dot)
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-hover")).click();
		
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	//checking Return date is enable or not
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}

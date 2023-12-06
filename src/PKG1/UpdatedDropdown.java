package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		System.out.println("Before Selection: "+driver.findElement(By.id("divpaxinfo")).getText());
		//If I want to add 5 Adult - than use while/for loop
/*		int i=1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("After Selection: "+driver.findElement(By.id("divpaxinfo")).getText());
*/
		
		//same output using for loop
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		//using testng assertion to validate the condition
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		//System.out.println("After Selection: "+driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(2000);
		
		///checkbox
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		//using testng assertion to validate the condition
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
		//count total checkbox in webpage
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

	}

}

package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement checkbox = driver.findElement(By.xpath("//label[@for='bmw']"));
		checkbox.findElement(By.id("checkBoxOption1")).click();
		
		System.out.println(checkbox.findElement(By.id("checkBoxOption1")).isSelected());
		
		if(checkbox.findElement(By.id("checkBoxOption1")).isSelected()==true)
		{
			String value = checkbox.getText();
		
			Select sc = new Select(driver.findElement(By.id("dropdown-class-example")));
			sc.selectByVisibleText(value);
		
			driver.findElement(By.id("name")).sendKeys(value);
			driver.findElement(By.id("alertbtn")).click();
			String alertText = driver.switchTo().alert().getText();
			System.out.println(alertText);
			if (alertText.contains(value))
			{
				driver.switchTo().alert().accept();
			}
						
		}	
		
	}

}

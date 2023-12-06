package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class staticDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//static drop down- we verify after inspect on webelement -if it display under <Select> tagname -its static

		WebElement staticDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dp = new Select(staticDropDown);
		dp.selectByIndex(3);
		System.out.println(dp.getFirstSelectedOption().getText());
		dp.selectByValue("AED");
		System.out.println(dp.getFirstSelectedOption().getText());
		dp.selectByVisibleText("INR");
		System.out.println(dp.getFirstSelectedOption().getText());
						
	}
}

package PKG1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SelIntroduction {

	public static void main(String[] args) {

		// Chrome driver setup
		/* System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();  */

		// Microsoft edge driver setup
		System.setProperty("webdriver.edge.driver", "C:/Users/Avinash/SeleniumTraining/Driver/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/");

		//to check title of web page -> driver.getTitle();
		//to display title on console we use sysout
		System.out.println("Title: "+driver.getTitle());
		System.out.println("Current Url: "+driver.getCurrentUrl());

		driver.close();  //it close current window

	}
}

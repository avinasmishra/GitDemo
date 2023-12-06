package PKG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String text="Avinash";
		driver.findElement(By.id("name")).sendKeys(text);
		
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
		String popupText = driver.switchTo().alert().getText();  //switchTo()- used here for popup because its js script and we don't have html code for that
		System.out.println(popupText);
		driver.switchTo().alert().accept();   // accept()- used for Ok button
		
		driver.findElement(By.cssSelector("#confirmbtn")).click();
		String textmsg = driver.switchTo().alert().getText();
		System.out.println(textmsg);
		driver.switchTo().alert().dismiss();     // dismiss()- used for cancel button 
		

	}

}

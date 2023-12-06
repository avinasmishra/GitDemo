package PKG2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinash\\SeleniumTraining\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//how to know how many frame in the webpage
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//first switch to frame by using- id/name/webElement
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		/*
		//by index
		driver.switchTo().frame(0);  */
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(source, dest).build().perform();
		//to come outside of frame
		driver.switchTo().defaultContent();
	}

}

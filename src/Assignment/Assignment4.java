package Assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinash\\SeleniumTraining\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		driver.findElement(By.linkText("Click Here")).click();

		//total window ids
		Set<String>windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		String childText = driver.findElement(By.cssSelector(".example")).getText();
		System.out.println("Child Text : "+childText);
		
		driver.switchTo().window(parentId);
		String parentText = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
		System.out.println("Parent Text : "+parentText);
	}

}

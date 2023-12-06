package PKG2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinash\\SeleniumTraining\\Driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		
		//how to know how many window/tab are opened- we use getWindowHandles() method
		Set<String> windows = driver.getWindowHandles();
		
		//how to switch to parent-child window: we use switchTo() method
		//but we have multiple windows id how to know which id need to be switch- use Iterator 
		Iterator<String> it = windows.iterator();
		
		String parentId = it.next();  //return 1st windows id
		String childId = it.next(); //return 2nd window id
		
		//now use switchTO()method
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		//how to extract from debug
		//1. write code for entire string //2. point breakpoint //3.start debug //4. select entire breakpoint code //5. right click //6. click on watch
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
		
		/*
		//Another way
		String text = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String[] split = text.split("at");
		String a =split[1].trim();
		String[] anotherSplit = a.split(" ");
		String email = anotherSplit[0];
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email); */
	}

}

package GreenKart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		//if user wants to purchase multiple products then- for that create array 
		String[] products = {"Brocolli","Tomato","Mushroom","Apple","Mango","Nuts Mixture"};
		//calling addItems method
		addItems(driver,products);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//apply promo code - rahulshettyacademy
		//use here explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//use here explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		String msg = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		System.out.println(msg);


	}

	//modifying main method- means creating a new method and paste all code in that method and call method in main method
	public static void addItems(WebDriver driver, String[] products)
	{
		int  j=0;
		List<WebElement> itemsName =driver.findElements(By.cssSelector("h4.product-name"));
		//convert array to list
		List<String> productItem = Arrays.asList(products);

		for(int i=0;i<itemsName.size();i++)
		{
			String items =itemsName.get(i).getText();
			//formating to get actual products
			String[] splitItems =items.split("-");
			String vegies=splitItems[0].trim();

			if(productItem.contains(vegies))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if(j==products.length) {
					break;
				}
			}
		}
	}
}


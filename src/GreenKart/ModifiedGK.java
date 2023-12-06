package GreenKart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModifiedGK {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//if user wants to purchase multiple products then- for that create array 
		String[] products = {"Brocolli","Tomato","Mushroom","Apple","Mango","Nuts Mixture"};
		//calling addItems method
		addItems(driver,products);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//apply promo code - rahulshettyacademy
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
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

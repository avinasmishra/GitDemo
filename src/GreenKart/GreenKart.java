package GreenKart;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Avinash/SeleniumTraining/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);
		int  j=0;
		//if user wants to purchase multiple products then- for that create array 
		String[] products = {"Brocolli","Tomato","Mushroom","Apple","Mango","Nuts Mixture"};

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

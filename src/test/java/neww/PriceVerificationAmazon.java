package neww;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PriceVerificationAmazon {
	@Test
	public void priceVerificationAmazon(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		int exp=1000;
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("android phone", Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Under ₹1,000']")).click();
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		for(WebElement price:prices) {
			String priceTxt = price.getText();
			Integer.parseInt(priceTxt);
			
		}
	}

}

package neww;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetAllPricesWithoutComma {
	@Test
	public void getAllPricesWithoutComma() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("refrigerator double door", Keys.ENTER);
		
		List<WebElement> eles = driver.findElements(By.xpath("//span[@class='a-price-whole'][number(translate(text(),',',''))]"));
		for(WebElement ele:eles) {
			System.out.println(ele.getText());
			
		}
	}

}

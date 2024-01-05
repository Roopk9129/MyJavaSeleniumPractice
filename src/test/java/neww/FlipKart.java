package neww;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipKart {
	@Test
	public void flipKart() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("Iphone 14", Keys.ENTER);
		List<WebElement> props = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		int count = 0;
		int pageNums = 1;
		String value = driver.findElement(By.xpath("//span[@class='_10Ermr']")).getText();
		String[] sp = value.split(" ");
		int expectedProducts = Integer.parseInt(sp[5]);
		System.out.println(expectedProducts);
		List<WebElement> pages = driver.findElements(By.xpath("//a[@class='ge-49M'][last()]"));
		for (WebElement page : pages) {
			for (WebElement ele : props) {
				count++;
				pageNums++;
				driver.findElement(By.xpath("//a[@class='ge-49M' and .='" + pageNums + "']")).click();
			}
		}

	}
}
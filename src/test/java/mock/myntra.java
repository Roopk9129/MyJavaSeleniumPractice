package mock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class myntra {
	@Test
	public void myntra1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[.='Home & Living']"))).perform();
		List<WebElement> HDs = driver.findElements(By.xpath("//ul[@data-reactid='575']"));
		for (WebElement ele : HDs) {
			System.out.println(ele.getText());

		}

	}

}

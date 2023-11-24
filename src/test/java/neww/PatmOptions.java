package neww;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PatmOptions {
	@Test
	public void patmOptions() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(By.xpath("//a[text()='Paytm For Business']"))).perform();
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Consumer Payments']"))).perform();
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Online Payments']"))).perform();
		List<WebElement> ops = driver
				.findElements(By.xpath("//a[text()='Online Payments']/following::ul/descendant::div[@class='_3y5vS']"));
		for (WebElement ele : ops) {
			String txt = ele.getText();
			System.out.println(txt);

		}
	}

}

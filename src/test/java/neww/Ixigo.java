package neww;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Ixigo {
	@Test
	public void ixigo() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.ixigo.com/");
		
		String expectedOrigin = "DEL - New Delhi";
		String expectedDest = "HYD - Hyderabad";

		Actions act = new Actions(driver);
		Robot robo = new Robot();

		act.moveByOffset(0, 40).click().perform();
		WebElement originWebEl = driver.findElement(By.xpath("//div[.='From']/input"));
		originWebEl.click();
		originWebEl.sendKeys(expectedOrigin);
		Thread.sleep(2000);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//div[.='To']/input")).sendKeys(expectedDest);
		Thread.sleep(2000);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//div[@class='u-ripple']")).click();
		String ActFrom = driver.findElement(By.xpath("//div[.='From']/input")).getAttribute("value");
		String ActTo = driver.findElement(By.xpath("//div[.='To']/input")).getAttribute("value");
		if (expectedOrigin.equals(ActFrom)) {
			System.out.println("Origin Validated");
		} else {
			System.out.println("Origin Validated Failed");
		}
		if (expectedDest.equals(ActTo)) {
			System.out.println("Destination Validated");
		} else {
			System.out.println("Destination Validated Failed");
		}

	}
}

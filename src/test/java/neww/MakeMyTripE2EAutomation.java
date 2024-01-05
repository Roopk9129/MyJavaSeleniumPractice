package neww;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MakeMyTripE2EAutomation {
	@Test
	public void makeMyTripE2EAutomation() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.makemytrip.com/");
		
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveByOffset(0, 40).click().perform();
		Thread.sleep(3000);
		act.moveByOffset(0, 40).click().perform();

		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("BLR");
		driver.findElement(By.xpath("//div[text()='BLR']")).click();
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("DEL");
		driver.findElement(By.xpath("//div[text()='DEL']")).click();
		
		String toDate = "//div[.='January 2024']/ancestor::div[@class='DayPicker-Months']/descendant::div[@class='DayPicker-Month']/preceding::div[@class='DayPicker-Body']/following::p[.='5']";
		for (;;) {
			try {
				driver.findElement(By.xpath(toDate)).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		driver.findElement(By.xpath("//a[.='Search']")).click();
		driver.findElement(By.xpath("//div[@class='commonOverlay ']/span")).click();
		driver.findElement(By.xpath("//div[@class='filtersOuter']/following::p[contains(.,' Non Stop')]")).click();
		List<WebElement> namesele = driver.findElements(By.xpath("//p[@class='fliCode']"));
		for (WebElement ele : namesele) {
			List<WebElement> nameandpriceele = driver.findElements(By.xpath("//p[.='"+ele.getText()+"']/ancestor::div[@class='listingCard  appendBottom5']/descendant::div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']"));
			for (WebElement elem : nameandpriceele) {
				String str = elem.getText();
				String st = str.replaceAll("per adult", "");
				System.out.print(ele.getText() + " - " + st);
				break;
			}
		}
	}
}

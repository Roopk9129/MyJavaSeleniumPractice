package neww;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MakeMyTrip {
	@Test
	public void makeMyTrip() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Actions act = new Actions(driver);
		act.moveByOffset(0, 40).click().perform();
		Thread.sleep(3000);
		act.moveByOffset(0, 40).click().perform();

		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath(
				"//div[@class='DayPicker-Months']/div['DayPicker-Month']/descendant::div[text()='December 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='7']"))
				.click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();
		driver.findElement(By.xpath("//p[text()='Popular Filters']/ancestor::div[@class='filtersOuter']/descendant::p[contains(text(),'IndiGo')]")).click();
		List<WebElement> eles = driver.findElements(By.xpath("//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice'][translate(text(),'₹ ,','')]"));
		
		for(WebElement ele: eles) {
			System.out.println(ele.getText());
			
		}
	}

}

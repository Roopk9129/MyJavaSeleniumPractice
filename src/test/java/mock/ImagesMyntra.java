package mock;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ImagesMyntra {
	@Test
	public void imagesMyntra() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[.='Men']"))).perform();
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By.xpath("//a[@data-reactid='41' and .='Jackets']"))).click().build()
				.perform();
		List<WebElement> imgs = driver.findElements(By.xpath("//img"));
		int count = 0;
		for (WebElement img : imgs) {
			count++;
		}
		System.out.println("Total number of images are: " + count);
		driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		driver.findElement(By.xpath("//label[.='Customer Rating']")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search for pr')]")).sendKeys("macroman",
				Keys.ENTER);
		List<WebElement> brands = driver.findElements(By.xpath("//h3[@class='product-brand']"));

		boolean flag = false;
		for (WebElement brand : brands) {
			String brandtxt = brand.getText();
			if (brandtxt.contains("Macroman")) {
				flag = true;
			}
		}
		if (flag) {
			System.out.println("All the results are from Macroman brand");
		} else {
			System.out.println("Results are not from Macroman brand");
		}
		driver.findElement(By.xpath("(//ul[@class='results-base']/li/a)[position()=7]")).click();
		ImagesMyntra im = new ImagesMyntra();
		im.windowHandles(driver, "Men ");
		driver.findElement(By.xpath("//p[@class='size-buttons-unified-size' and .='S']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-bag pdp-button pdp-flex pdp-center')]")).click();
		String bag = driver.findElement(By.xpath("//span[.='1']")).getText();
		int num = Integer.parseInt(bag);
		if (num == 1) {
			System.out.println("Successfully added to Bag");
		} else {
			System.out.println("Verification failed");
		}
	}

	public void windowHandles(WebDriver driver, String ExpactedTitle) {
		Set<String> hls = driver.getWindowHandles();
		for (String str : hls) {
			String actTitle = driver.getTitle();
			driver.switchTo().window(str);
			if (actTitle.contains(ExpactedTitle)) {
				break;
			}
		}
	}
}
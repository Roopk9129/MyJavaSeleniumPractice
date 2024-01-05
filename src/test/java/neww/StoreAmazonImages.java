package neww;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class StoreAmazonImages {
	@Test
	public void storeAmazonImages() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("lights", Keys.ENTER);
		List<WebElement> imgs = driver.findElements(By.xpath("//img[@class='s-image']"));
		StoreAmazonImages sai = new StoreAmazonImages();
		for (WebElement img : imgs) {
			int ranint = new Random().nextInt(10000);
			try {
				sai.ts("H:\\Amazon\\Image_" + ranint + ".png", img);
			}
			catch (Exception e) {
			}
		}
	}
	public void ts(String path, WebElement ele) throws Throwable {
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		FileHandler.copy(src, dst);	
	}
}

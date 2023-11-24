package neww;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WorldOMeter {
	@Test
	public void wordOMeter() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.worldometers.info/world-population/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		for (;;) {
			String ele = driver.findElement(By.xpath("//div[@id='maincounter-wrap']/div/span")).getText();
			System.out.println(ele);
			try {
				Runtime.getRuntime().exec("cls");
			} catch (Exception e) {
			}
		}
	}
}
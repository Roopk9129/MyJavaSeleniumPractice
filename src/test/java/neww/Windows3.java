package neww;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Windows3 {
	@Test
	public void windows3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
		WebElement ele = driver.findElement(By.xpath(
				"//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']/following::span[text()='Apple iPhone 13 (128GB) - Blue']"));
		String text = ele.getText();
		ele.click();
		Windows3 w = new Windows3();
		w.windowHandles(driver, text);
		driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
	}

	public void windowHandles(WebDriver driver, String title) {
		Set<String> hand = driver.getWindowHandles();
		for (String h : hand) {
			driver.switchTo().window(h);
			String tit = driver.getTitle();
			if (tit.equalsIgnoreCase(title)) {
				break;

			}
		}
	}

	@Test
	public void m1() {
		String str = "abc123";
		String beforeReverse = new String();
		String afterReverse = new String();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				int num = Character.getNumericValue(str.charAt(i));
				beforeReverse = beforeReverse + "" + num;
				afterReverse = num + "" + afterReverse;
			}
		}
		int a = Integer.parseInt(beforeReverse);
		int b = Integer.parseInt(afterReverse);
		System.out.println(a + b);
	}
}

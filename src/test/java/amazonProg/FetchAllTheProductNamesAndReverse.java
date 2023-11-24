package amazonProg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FetchAllTheProductNamesAndReverse {
	@Test
	public void fetchAllTheProductNamesAndReverse() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("cookies", Keys.ENTER);
		List<WebElement> lweb = driver
				.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		for (WebElement ele : lweb) {
			String txt = ele.getText();
			char[] ch = txt.toCharArray();
			System.out.print(txt+" --> ");
			for (int i = txt.length() - 1; i >= 0; i--) {
				System.out.print(ch[i]);

			}
			System.out.println();

		}

	}

}

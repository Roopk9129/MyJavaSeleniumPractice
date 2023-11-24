package amazonProg;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class all {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int li = 0;
		int but = 0;
		int img = 0;
		List<WebElement> all = driver.findElements(By.xpath("//a|//button|//img"));
		for (int i = 0; i < all.size(); i++) {
			if (all.get(i).getTagName().equals("a")) {
				li++;
			} else if (all.get(i).getTagName().equals("img")) {
				img++;
			} else
				but++;
		}
		System.out.println("links : " + li);
		System.out.println("buttons : " + but);
		System.out.println("images : " + img);
		driver.quit();

	}

}

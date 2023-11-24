package ListOfPrograms;

import java.time.Duration;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoSugg {
	@Test
	public void autoSugg() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Indian");
		List<WebElement> eles = driver.findElements(By.xpath("//span[contains(text(),'Indian')]"));
	
		TreeSet<Object> set = new TreeSet<>();
		for (WebElement ele : eles) {
			set.add(ele.getText());

		}
		System.out.println(set.descendingSet());

	}
}

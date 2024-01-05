package neww;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class c1 {
	@Test
	public void C1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement welcome = driver.findElement(By.xpath("//div[text()='Welcome aboard']"));
		System.out.println(welcome.getText());
		driver.navigate().refresh();
		System.out.println(welcome.getText());

	}

}

package Dummy;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandles {
	@Test
	public void windowHandles() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.findElement(By.xpath("//a[text()='Open Seperate Multiple Windows']")).click();
		driver.findElement(By.xpath("//button[text()='click ']")).click();
		Set<String> hs = driver.getWindowHandles();
		for (String str : hs) {
			System.out.println(str);

		}

	}

}

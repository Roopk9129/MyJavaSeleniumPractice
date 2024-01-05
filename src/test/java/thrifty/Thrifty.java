package thrifty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Thrifty {
	@Test
	public void thrifty() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.thrifty-work1.com/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//uni-view[.='LOG IN']")).click();
		driver.findElement(By.xpath("//input[@class='uni-input-input' and @type='number' ]")).sendKeys("8309304414");
		driver.findElement(By.xpath("//input[@class='uni-input-input' and @type='password' ]")).sendKeys("roop963");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//uni-button[@type='warn' ]")).click();
		driver.findElement(By.xpath("//uni-view[.='Find a car now']")).click();
		for (int i = 0; i <= 35; i++) {

			driver.findElement(By.xpath("//uni-view[@class='booking']")).click();
			Thread.sleep(7000);

			driver.findElement(By.xpath("//uni-view[.='SUBMIT']")).click();
			Thread.sleep(7000);

		}

	}
	@Test
	public void m1() {
		char s ='S';
		System.out.println(1+5+s+12+13);
	}
}

package Dummy;

import java.time.Duration;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {
	@Test
	public void dropDown() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		TreeSet<String> set = new TreeSet<>();
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='first']")));
		List<WebElement> opts = sel.getOptions();
		for (WebElement ele : opts) {
			set.add(ele.getText());
		}
		System.out.println("Assending Order" + set);
		System.out.println("Desending Order" + set.descendingSet());

	}
}

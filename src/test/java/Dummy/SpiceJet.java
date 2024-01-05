package Dummy;

import java.time.Duration;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SpiceJet {
	@Test
	public void spiceJet() throws Throwable {
		// inputs
		String from = "Beng";
		String to = "Delhi";
		String month = "January";
		String year = "2024";
		String date = "5";
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[.='From' and contains(@data-testid,'to')]")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::input")).sendKeys(from);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/descendant::input")).sendKeys(to);
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-" + month + "-" + year
				+ "']/descendant::div[@data-testid='undefined-calendar-day-" + date + "']")).click();
		driver.findElement(By.xpath("//div[contains(@data-testid,'h') and contains(.,'S')]")).click();
		String txt = driver
				.findElement(By.xpath("//div[contains(@class,'css-76zvg2 r-homxoj r-1h')]/span[position()=1]"))
				.getText();
		String txtr = txt.replaceAll("One Way : ", "");
		String[] strsp = txtr.split(" to ");

		// Origin and Destination Validation
		if (strsp[0].contains(from)) {
			System.out.println("Origin Validation Successful");
		} else {
			System.out.println("Origin Validation Unsuccessful");
		}
		if (strsp[1].contains(to)) {
			System.out.println("Destination Validation Successful");
		} else {
			System.out.println("Destination Validation Unsuccessful");
		}

		// Date Validation
		String datev = driver
				.findElement(By.xpath("//span[@class='css-76zvg2 css-16my406 r-homxoj r-1s6pnzw'][position()=2]"))
				.getText();
		String datevR = datev.replaceAll("Depart Date : ", "");
		String[] datevRSp = datevR.split(" ");
		if (datevRSp[2].contains(month)) {
			System.out.println("Month Validation Successful");
		} else {
			System.out.println("Month Validation Successful");
		}
		if (datevRSp[3].contains(year)) {
			System.out.println("Year Validation Successful");
		} else {
			System.out.println("Year Validation Unsuccessful");
		}
		List<WebElement> eles = driver.findElements(By.xpath(
				"//div[contains(@class,'css-1dbjc4n r-1awozwy r-1s')]/descendant::div[contains(@class,'css-76zvg2 r-h')]"));
		TreeSet<Integer> set = new TreeSet<>();
		for (WebElement ele : eles) {
			String pricestr = ele.getText();
			String pricestrR = pricestr.replaceAll("₹ ", "");
			String remvecomma = pricestrR.replaceAll(",", "");
			int priceint = Integer.parseInt(remvecomma);
			set.add(priceint);

		}
		Object[] arr = set.toArray();
		System.out.println(arr[0]);

	}

}

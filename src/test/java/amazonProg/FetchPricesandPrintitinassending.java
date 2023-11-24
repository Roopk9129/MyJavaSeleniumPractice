package amazonProg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.TreeSet;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FetchPricesandPrintitinassending {
	@Test
	public void fetchPricesandPrintitinassending()
			throws Throwable, InvalidFormatException, FileNotFoundException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("cookies", Keys.ENTER);
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		TreeSet<Integer> set = new TreeSet<>();
		for (WebElement ele : prices) {
			String priceStr = ele.getText();
			int priceInt = Integer.parseInt(priceStr);
			set.add(priceInt);
		}
		Object[] arr = set.toArray();
		Workbook wb = WorkbookFactory.create(new FileInputStream("./src/main/resources/w1.xlsx"));
		Sheet sheet = wb.createSheet("Amazon");

		int count = 0;
		for (Object obj : arr) {
			String st = obj.toString();
			sheet.createRow(count).createCell(0).setCellValue(st);
			count++;
			System.out.println(obj);
			FileOutputStream fos = new FileOutputStream("./src/main/resources/w1.xlsx");
			wb.write(fos);

		}

	}
}

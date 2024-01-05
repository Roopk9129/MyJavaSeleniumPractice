package neww;

import java.io.FileInputStream;
import java.time.Duration;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;
public class SpiceJetAutomationtest {
	@Test(dataProvider = "dp",invocationCount = 5
			)
	public void spiceJetAutomation(String PFName, String PLName, String phNo, String SID, String Email) throws Throwable {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::input")).sendKeys("BLR");
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/descendant::input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/descendant::input")).sendKeys("DELHI");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='January ' and text()='2024']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='1']")).click();
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[.='Students']")).click();
		driver.findElement(By.xpath("//div[.='Search Flight' and contains(@class,'css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-')]")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/descendant::div[@class='css-1dbjc4n r-zso239']/*[name()='svg']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
		driver.findElement(By.xpath("//div[@data-testid='continue-search-page-cta']")).click();
		driver.findElement(By.xpath("//input[@data-testid='first-inputbox-contact-details']")).sendKeys(PFName);
		driver.findElement(By.xpath("//input[@data-testid='last-inputbox-contact-details']")).sendKeys(PLName);
		driver.findElement(By.xpath("//input[@data-testid='contact-number-input-box']")).sendKeys(phNo);
		driver.findElement(By.xpath("//input[@data-testid='emailAddress-inputbox-contact-details']")).sendKeys(Email);		
		driver.findElement(By.xpath("//input[@data-testid='traveller-0-first-traveller-info-input-box']")).sendKeys(PFName);
		driver.findElement(By.xpath("//input[@data-testid='traveller-0-last-traveller-info-input-box']")).sendKeys(PLName);
		driver.findElement(By.xpath("//input[@data-testid='sc-member-mobile-number-input-box']")).sendKeys(phNo);
		try {
		driver.findElement(By.xpath("//div[.='Student ID Card*']/div/input")).sendKeys(SID);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		driver.findElement(By.xpath("//div[@class ='css-76zvg2 r-jwli3a r-poiln3 r-ubezar r-1kfrs79' and .='Next']")).click();
		driver.findElement(By.xpath("//input[@data-testid='traveller-1-first-traveller-info-input-box']")).sendKeys(PFName+" S");
		driver.findElement(By.xpath("//input[@data-testid='traveller-1-last-traveller-info-input-box']")).sendKeys(PLName);
		driver.findElement(By.xpath("//input[@data-testid='sc-member-mobile-number-input-box']")).sendKeys(phNo);
		try {
			driver.findElement(By.xpath("//div[.='Student ID Card*']/div/input")).sendKeys(SID);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		driver.findElement(By.xpath("//div[.='Continue']")).click();	
		driver.quit();
	}
	
	@DataProvider
	public Object[][] dp() throws Throwable {
		Workbook WB = WorkbookFactory.create(new FileInputStream("./src/main/resources/SpiceJetPassengerDetails.xlsx"));
		Sheet sheet = WB.getSheet("Sheet1");
		int LastRow = sheet.getLastRowNum();
		Row row = sheet.getRow(0);
		int LastCell = row.getLastCellNum();
		Object[][] obj = new Object[LastRow][LastCell];
		for (int r = 0; r < LastRow; r++) {
			for (int c = 0; c < LastCell; c++) {
				obj[r][c] = sheet.getRow(r).getCell(c).getStringCellValue();
			}
		}
		return obj;
	}
}
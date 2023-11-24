package EndToEndScenarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;
import Repo.HomePage;

public class E2E_AmazonExcelDB {
	@Test(priority = 0)
	public void e2E_AmazonExcelDB() throws Throwable {
		Driver drive = new Driver();
		DriverManager.registerDriver(drive);
		String query = "insert into ProductNames (names) values('Mobile phone');";
		String query1 = "insert into ProductNames (names) values('washing machine');";
		String query2 = "insert into ProductNames (names) values('laptop');";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PracticeDB", "root", "root");
		Statement state = con.createStatement();
		int up = state.executeUpdate(query);
		int up1 = state.executeUpdate(query1);
		int up2 = state.executeUpdate(query2);
		if (up >= 1 && up1 >= 1 && up2 >= 1) {
			System.out.println("Successfully Inserted");
		} else {
			System.out.println("Failed to Insert");
		}
	}
	@Test
	public void searchProducts() throws Throwable {
		String query = "select * from ProductNames;";
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PracticeDB", "root", "root");
		ResultSet qu = con.createStatement().executeQuery(query);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		HomePage hp = new HomePage(driver);
		WebElement searchbox = hp.getSearchBox();
		List<WebElement> names = hp.getPnames();
		FileInputStream fis = new FileInputStream("./src/main/resources/Write.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int count = 0;
		while (qu.next()) {
			searchbox.sendKeys(qu.getString(1), Keys.ENTER);
			for (WebElement ele : names) {
				sh.createRow(count).createCell(0).setCellValue(ele.getText());
				count++;
				FileOutputStream fos = new FileOutputStream("./src/main/resources/Write.xlsx");
				wb.write(fos);
				System.out.println(ele.getText());
			}
			searchbox.clear();
		}
		driver.quit();
	}
}

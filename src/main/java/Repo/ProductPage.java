package Repo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//h3[@class='product-brand']")
	private List<WebElement> brands;
	
	public List<WebElement> getBrands() {
		return brands;
	}
	
	

}

package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Category {
	public WebDriver driver;

	public Category(WebDriver driver) {
		this.driver = driver;
	}

	By categor = By.className("hmenu-item");
	By itm = By.xpath("//span[contains(@class,'a-size-base a-color-base')]");

	public void selectCat(String category) throws InterruptedException {

		List<WebElement> cats = driver.findElements(categor);
		for (int i = 0; i < cats.size(); i++) {
			String specs = cats.get(i).getText();
			if (specs.contentEquals(category)) {
				cats.get(i).click();		
				break;
			}

		}

	}

	public void selectItem(String itemname) throws InterruptedException {

		List<WebElement> cats = driver.findElements(itm);
		for (int i = 0; i < cats.size(); i++) {
			String specs = cats.get(i).getText();
			if (specs.contentEquals(itemname)) {
				cats.get(i).click();
				break;
			}

		}

	}
}

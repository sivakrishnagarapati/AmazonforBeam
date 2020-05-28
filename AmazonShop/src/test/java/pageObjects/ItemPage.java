package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
	public WebDriver driver;

	public ItemPage(WebDriver driver) {
		this.driver = driver;
	}

	By specs = By.xpath("//span[contains(@class,'a-color-base a-text-normal')]");

	By cart = By.cssSelector("#add-to-cart-button");
	By specsdtl = By.cssSelector(".a-size-medium.sc-product-title.a-text-bold");
	//By price = By.cssSelector("#sc-subtotal-amount-buybox");
	By price = By.xpath("//span[contains(@class,'a-color-price sc-price-container')]/span");
	By quan = By.cssSelector("#a-autoid-0-announce");
	By maxquan = By.cssSelector("#dropdown1_9");
	By quantext = By.cssSelector("input[name='quantityBox']");
	By update = By.cssSelector("#a-autoid-1");
	By delete = By.cssSelector("input[value='Delete']");

	public void selectSpecs(String specification) throws InterruptedException {

		List<WebElement> prods = driver.findElements(specs);
		for (int i = 0; i < prods.size(); i++) {
			String specs = prods.get(i).getText();
			if (specs.contentEquals(specification)) {
				prods.get(i).click();
				break;
			}

		}

	}

	public void validateCart(String specifics) throws InterruptedException {
		Assert.assertTrue(driver.findElement(specsdtl).getText().contentEquals(specifics));

	}

	public WebElement addtoCart() {
		return driver.findElement(cart);
	}

	public WebElement itemPrice() {
		return driver.findElement(price);
	}

	public WebElement quantity() {
		return driver.findElement(quan);
	}

	public WebElement maxQuantity() {
		return driver.findElement(maxquan);
	}

	public WebElement quanText() {
		return driver.findElement(quantext);
	}

	public WebElement upDate() {
		return driver.findElement(update);
	}

	public void deLete(String specification2) {
		List<WebElement> selecteditems = driver.findElements(specsdtl);

		for (int i = 0; i < selecteditems.size(); i++) {
			String selecteditem = selecteditems.get(i).getText();
			if (selecteditem.contentEquals(specification2)) {
				WebElement dele = driver.findElement(delete);
				dele.click();
				Assert.assertFalse(driver.findElement(specsdtl).getText().contentEquals(specification2));
				break;
			}

		}

	}
}

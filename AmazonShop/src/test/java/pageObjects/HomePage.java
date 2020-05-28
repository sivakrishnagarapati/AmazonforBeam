package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Cucumber.AmazonShop.Base;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By searchfield = By.cssSelector("#twotabsearchtextbox");
	By searchgo = By.cssSelector(".nav-input");
	By cartbtn = By.cssSelector("#hlb-view-cart");
	By acclist = By.cssSelector("#nav-link-accountList");
	By hamburger = By.id("nav-hamburger-menu");
	By maintab = By.id("nav-xshop");
	By links = By.tagName("a");
	By department = By.className("nav-search-facade");
	By departdropdown = By.id("searchDropdownBox");
	By prime = By.id("nav-link-prime");
	By tryprime = By.id("prime-header-CTA");

	public WebElement searchField() {
		return driver.findElement(searchfield);
	}

	public WebElement searchGo() {
		return driver.findElement(searchgo);
	}

	public WebElement cartBtn() {
		return driver.findElement(cartbtn);
	}

	public WebElement accList() {
		return driver.findElement(acclist);
	}

	public WebElement hamBurger() {
		return driver.findElement(hamburger);
	}

	public void mainTab() {
		WebElement miniDriver = driver.findElement(maintab);
		int linkssize = miniDriver.findElements(links).size();
		int linkssiz = linkssize - 1;
		for (int i = 0; i < linkssiz; i++) {
			String Click = Keys.chord(Keys.CONTROL, Keys.ENTER);
			miniDriver.findElements(links).get(i).sendKeys(Click);
		}

	}

	public void validateTabs() {
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			Assert.assertNotEquals("404 - Document Not Found", driver.getTitle());
		}
	}

	public void departMent(String department) {

		Select sele = new Select(driver.findElement(departdropdown));
		sele.selectByVisibleText(department);
	}

	public WebElement priMe() {
		return driver.findElement(prime);
	}

	public WebElement tryPrime() {
		return driver.findElement(tryprime);
	}

}

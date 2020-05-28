package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccount {
	public WebDriver driver;

	public CreateAccount(WebDriver driver) {
		this.driver = driver;
	}

	By createacc = By.cssSelector("#createAccountSubmit");
	By name = By.cssSelector("#ap_customer_name");
	By mnumber = By.cssSelector("#ap_phone_number");
	By password = By.cssSelector("#ap_password");
	By continu = By.cssSelector("#continue");
	By verifynumber = By.cssSelector("h1");
	By email = By.id("ap_email");
	By passwordcheck = By.id("ap_password_check");

	public WebElement createAcc() {
		return driver.findElement(createacc);
	}

	public WebElement naME() {
		return driver.findElement(name);
	}

	public WebElement mNumber() {
		return driver.findElement(mnumber);
	}

	public WebElement passWord() {
		return driver.findElement(password);
	}

	public WebElement conTinu() {
		return driver.findElement(continu);
	}

	public void verifyNumber() {
		String s = driver.findElement(verifynumber).getText();
		Assert.assertTrue(s.contentEquals("Verify mobile number"));

	}

	public WebElement emaIL() {
		return driver.findElement(email);
	}

	public WebElement passwordCheck() {
		return driver.findElement(passwordcheck);
	}

	public void verifyEmail() {
		String s = driver.findElement(verifynumber).getText();
		Assert.assertTrue(s.contentEquals("Verify email address"));

	}

}

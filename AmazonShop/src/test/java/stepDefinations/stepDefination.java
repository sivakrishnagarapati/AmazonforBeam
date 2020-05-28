package stepDefinations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Cucumber.AmazonShop.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import junit.framework.Assert;
import pageObjects.Category;
import pageObjects.CreateAccount;
import pageObjects.HomePage;
import pageObjects.HomePage;
import pageObjects.ItemPage;

@RunWith(Cucumber.class)
public class stepDefination {

	public WebDriver driver = null;
	static HomePage homepage;
	ItemPage itempage;
	CreateAccount createaccount;
	Category catepage;

	@Given("^Browser is launched and Amazon web URL is entered$")
	public void browser_is_launched_and_amazon_web_url_is_entered() throws Throwable {
		driver = Base.getDriver();
	}

	@When("^Search for a product (.+) of specs (.+)$")
	public void search_for_a_product_of_specs(String product, String specification) throws Throwable {
		homepage = new HomePage(driver);
		itempage = new ItemPage(driver);
		homepage.searchField().sendKeys(product);
		homepage.searchGo().click();
		itempage.selectSpecs(specification);

	}

	@Then("^Add the product to the cart$")
	public void add_the_product_to_the_cart() throws Throwable {
		itempage = new ItemPage(driver);
		itempage.addtoCart().click();
		Thread.sleep(3000);
	}

	@And("^Validate the cart has (.+)$")
	public void validate_the_cart_has(String specifics) throws Throwable {
		homepage = new HomePage(driver);
		itempage = new ItemPage(driver);
		homepage.cartBtn().click();
		itempage.validateCart(specifics);
	}

	@And("^Increase the item quantity to \"([^\"]*)\"$")
	public void increase_the_item_quantity_to_something(String quantity) throws Throwable {
		itempage = new ItemPage(driver);
		String price = itempage.itemPrice().getText();
		String prices = price.replace("S$", "");
		System.out.println(prices);
		Thread.sleep(2000);
		float originalprice = Float.parseFloat(prices);
		itempage.quantity().click();
		itempage.maxQuantity().click();
		Actions action = new Actions(driver);
		action.sendKeys("quantity");
		itempage.quanText().sendKeys(quantity);
		itempage.upDate().click();
		Thread.sleep(5000);
		String total = itempage.itemPrice().getText();
		String totals = total.replace("S$", "");
		Double totalprice = Double.parseDouble(totals);

		int quantiti = Integer.parseInt(quantity);
		float exptotal = originalprice * quantiti;
		BigDecimal bd = new BigDecimal(exptotal).setScale(2, RoundingMode.HALF_UP);
		double expectedtotal = bd.doubleValue();
		Assert.assertEquals(expectedtotal, totalprice);

	}

	@And("^Remove item from the cart (.+)$")
	public void remove_item_from_the_cart(String specification2) throws Throwable {
		itempage = new ItemPage(driver);
		itempage.deLete(specification2);
	}

	@When("^User clickson Account and list$")
	public void user_clickson_account_and_list() throws Throwable {
		homepage = new HomePage(driver);
		homepage.accList().click();
	}

	@And("^User clickon create account$")
	public void user_clickon_create_account() throws Throwable {
		createaccount = new CreateAccount(driver);
		createaccount.createAcc().click();
	}

	@And("^User enter the details and continue$")
	public void user_enter_the_details_and_continue(DataTable data) throws Throwable {
		List<String> dt = data.asList();
		createaccount = new CreateAccount(driver);
		createaccount.naME().sendKeys(dt.get(0));
		createaccount.mNumber().sendKeys(dt.get(1));
		createaccount.passWord().sendKeys(dt.get(2));
		createaccount.conTinu().click();
	}

	@And("^User enter the required details and continue$")
	public void user_enter_the_required_details_and_continue(DataTable data) throws Throwable {
		List<String> dt = data.asList();
		createaccount = new CreateAccount(driver);
		createaccount.naME().sendKeys(dt.get(0));
		createaccount.emaIL().sendKeys(dt.get(1));
		createaccount.passWord().sendKeys(dt.get(2));
		createaccount.passwordCheck().sendKeys(dt.get(2));
		createaccount.conTinu().click();
	}

	@Then("^User will be asked to enter the OTP$")
	public void user_will_be_asked_to_enter_the_otp() throws Throwable {
		createaccount = new CreateAccount(driver);
		createaccount.verifyNumber();
	}

	@Then("^User will be asked to enter the OTP from email$")
	public void user_will_be_asked_to_enter_the_otp_from_email() throws Throwable {
		createaccount = new CreateAccount(driver);
		createaccount.verifyEmail();
	}

	@When("^User clickson shop by category option$")
	public void user_clickson_shop_by_category_option() throws Throwable {
		homepage = new HomePage(driver);
		homepage.hamBurger().click();
		Thread.sleep(3000);
	}

	@Then("^Category list should displayed and user should select (.+)$")
	public void category_list_should_displayed_and_user_should_select(String category) throws Throwable {
		catepage = new Category(driver);
		catepage.selectCat(category);
		Thread.sleep(3000);
	}

	@And("^Main menu should displayed and user should select (.+)$")
	public void main_menu_should_displayed_and_user_should_select(String mainmenu) throws Throwable {
		catepage = new Category(driver);
		catepage.selectCat(mainmenu);
		Thread.sleep(3000);
	}

	@And("^User should be able select the (.+)$")
	public void user_should_be_able_select_the(String itemname) throws Throwable {
		catepage = new Category(driver);
		catepage.selectItem(itemname);
	}

	@When("^User clickson main tabs$")
	public void user_clickson_main_tabs() throws Throwable {
		homepage = new HomePage(driver);
		homepage.mainTab();
	}

	@Then("^all the tabs should be opened successfully without any errors$")
	public void all_the_tabs_should_be_opened_successfully_without_any_errors() throws Throwable {
		homepage = new HomePage(driver);
		homepage.validateTabs();
	}

	@When("^User selects the deaprtment (.+)$")
	public void user_selects_the_deaprtment(String department) throws Throwable {
		homepage = new HomePage(driver);
		homepage.departMent(department);
	}

	@When("^User clickson Try Prime link$")
	public void user_clickson_try_prime_link() throws Throwable {
		homepage = new HomePage(driver);
		homepage.priMe().click();
		homepage.tryPrime().click();
	}

	@After("@PositiveTest")
	public void hook1()

	{

		driver.quit();
	}

	@After("@NegativeTest")
	public void hook2()

	{

		driver.quit();
	}

}

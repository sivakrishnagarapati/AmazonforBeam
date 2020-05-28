Feature: Amazon web shop sample test cases
Background: 
Given Browser is launched and Amazon web URL is entered

@PositiveTest
Scenario Outline: Search for the product
When Search for a product <Product> of specs <Specification>

Examples:
|Product 	|Specification																							 |
|watch		|Suunto Core All Black Military Men's Outdoor Sports Watch - SS014279010|

@PositiveTest
Scenario Outline: Adding products to the cart
When Search for a product <Product> of specs <Specification>
Then Add the product to the cart
And Validate the cart has <Specification>

Examples:
|Product 			|Specification																							 |
|samsung s20		|Samsung Galaxy S20+ Smartphone, 64-bit Octa-Core, 8 GB, 128 GB ROM, 6.7" Display, Android 10, Cloud Blue|

@PositiveTest
Scenario Outline: Adding products to the cart and updating the quantity
When Search for a product <Product> of specs <Specification>
Then Add the product to the cart
And Validate the cart has <Specification>
And Increase the item quantity to "10"

Examples:
|Product 			|Specification				 											   |
|tv remote			|PDP Talon Media Remote Control for Xbox One, TV, Blu-ray & Streaming Media|

@PositiveTest
Scenario Outline: Adding multiple products to the cart
When Search for a product <Product1> of specs <Specification1>
Then Add the product to the cart
And Validate the cart has <Specification1>
When Search for a product <Product2> of specs <Specification2>
Then Add the product to the cart
And Validate the cart has <Specification2>

Examples:
|Product1|Specification1|Product2|Specification2|
|samsung s20|Samsung Galaxy S20+ Smartphone, 64-bit Octa-Core, 8 GB, 128 GB ROM, 6.7" Display, Android 10, Cloud Blue|wireless earbuds|Jabra Elite Active 65t True Wireless Earbuds, Copper Blue|


@PositiveTest
Scenario Outline: Adding multiple products to the cart and remove added item from the cart
When Search for a product <Product1> of specs <Specification1>
Then Add the product to the cart
And Validate the cart has <Specification1>
When Search for a product <Product2> of specs <Specification2>
Then Add the product to the cart
And Validate the cart has <Specification2>
And Remove item from the cart <Specification2>

Examples:
|Product1|Specification1|Product2|Specification2|
|samsung s20|Samsung Galaxy S20+ Smartphone, 64-bit Octa-Core, 8 GB, 128 GB ROM, 6.7" Display, Android 10, Cloud Blue|wireless earbuds|Jabra Elite Active 65t True Wireless Earbuds, Copper Blue|

@NegativeTest
Scenario: Account creation until OTP
When User clickson Account and list
And User clickon create account
And User enter the details and continue
|sivakrishna|90000000|Password|
Then User will be asked to enter the OTP


@PositiveTest
Scenario Outline: Searching and additing products by category
When User clickson shop by category option
Then Category list should displayed and user should select <Category>
And Main menu should displayed and user should select <MainMenu>
And User should be able select the <ItemName>
Then Add the product to the cart

Examples:
|Category|MainMenu|ItemName		|
|Books	 |Fiction |Normal People|


@NegativeTest
Scenario: Clicking on main tabs of Amazon and ensuring no page not found errors
When User clickson main tabs
Then all the tabs should be opened successfully without any errors


@PositiveTest
Scenario Outline: Adding products to the cart by selecting department
When User selects the deaprtment <Department>
When Search for a product <Product> of specs <Specification>
Then Add the product to the cart
And Validate the cart has <Specification>

Examples:
|Department			|Product 	|Specification										   	   |
|Kitchen & Dining	|spoon set	|Disney Princess - Fork and Spoon Set (Pretty As A Princess)|


@NegativeTest
Scenario: Try Prime and account creation until OTP
When User clickson Try Prime link
And User clickon create account
And User enter the required details and continue
|sivakrishna|sivakrishna@test.com|Password|
Then User will be asked to enter the OTP from email

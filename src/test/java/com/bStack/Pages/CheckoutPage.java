package com.bStack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	//Encapsulation
	public WebDriver driver;
	
	//Initialize driver
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//checkout locators
	@FindBy(xpath = "//div[@class='buy-btn']")WebElement checkout;
	@FindBy(id = "firstNameInput")WebElement fname;
	@FindBy(id = "lastNameInput")WebElement lname;
	@FindBy(id = "addressLine1Input")WebElement addr;
	@FindBy(id = "provinceInput")WebElement province;
	@FindBy(id = "postCodeInput")WebElement pincode;
	@FindBy(id = "checkout-shipping-continue")WebElement submitBtn;
	@FindBy(id = "confirmation-message")WebElement confirmMsg;
	@FindBy(xpath = "//div[text()='Your order number is ']")WebElement orderMsg;
	@FindBy(tagName = "strong")WebElement orderNumber;
	@FindBy(id = "downloadpdf")WebElement downloadReceipt;
	@FindBy(className = "optimizedCheckout-buttonSecondary")WebElement continueShopBtn;
	
	//cart button
	@FindBy(className = "bag--float-cart-closed")WebElement bag;
	
	//floatCart
	@FindBy(className = "shelf-empty")WebElement emptyCart;
	@FindBy(xpath = "//div[text()='Continue Shopping']")WebElement cartContShoppingBtn;
	
	

	//Methods
	public String checkoutProcess() {
		checkout.click();
		fname.sendKeys("Ankita");
		lname.sendKeys("Kabra");
		addr.sendKeys("1-A-7");
		province.sendKeys("Rajasthan");
		pincode.sendKeys("311001");
		submitBtn.click();
		return confirmMsg.getText();
	}
	
	public void orderDetails() {
		System.out.println(orderMsg.getText());
		downloadReceipt.click();
	}
	
	public void emptyBag() {
		continueShopBtn.click();
		bag.click();
		
		if(emptyCart.getText().contains("Add some products in the bag")) {
			System.out.println("Add some products in your cart first!!");
			cartContShoppingBtn.click();
		}
		
	}
	

}

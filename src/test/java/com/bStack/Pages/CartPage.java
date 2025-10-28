package com.bStack.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	
	//Encapsulation
	private WebDriver driver;
	//private WebDriver wait;
	
	//Initialize driver
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy(xpath = "//div[@data-sku='iPhone12-device-info.png']//div[text()='Add to cart'][1]")WebElement iPhone12;
	@FindBy(xpath = "//div[@data-sku='iPhone11-device-info.png']//div[text()='Add to cart']")WebElement iPhone11;
	@FindBy(xpath = "//div[@data-sku='samsung-S20-device-info.png']//div[text()='Add to cart']")WebElement galaxyS20;
	@FindBy(xpath = "//div[@data-sku='GooglePixel4-device-info.png']//div[text()='Add to cart']")WebElement pixel4;
	@FindBy(xpath = "//div[@data-sku='samsung-S10-device-info.png']//div[text()='Add to cart']")WebElement samsungS10;
	@FindBy(xpath = "//div[@data-sku='OnePlus8-device-info.png']//div[text()='Add to cart']")WebElement onePlus8T;
	
	//all addToCart items
	@FindBy(className = "shelf-item__del")List<WebElement> cartItem;
	@FindBy(className = "sub-price__val")WebElement bagPrice;
	
	//Methods
	public void addToCart() {
		iPhone12.click();
		
	}
	
	public int addMultipleItems() {
		iPhone11.click();
		galaxyS20.click();
		pixel4.click();
		samsungS10.click();
		//onePlus8T.click();
		return cartItem.size();
	}
	
	public String cartAmount() {
		
		return bagPrice.getText();
	}
	
	public void removeItem(int max) {
		
		int count = 1;
		System.out.println("Available Product in the cart are: "+ cartItem.size());
		
		for(WebElement i : cartItem) {
			i.click();
			count++;
			if(count > max) {
			break;
			}
		}
		System.out.println("Remaining items in the cart are: " + cartItem.size());
	}
	
	public int getAllCartItems() {
		return cartItem.size();
	}
}

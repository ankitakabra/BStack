package com.bStack.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	//Encapsulation
	private WebDriver driver;
	//private WebDriver wait;
	
	//Initialize driver
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	
	@FindBy(id = "signin")WebElement signIn;
	@FindBy(id = "username")WebElement userName;
	@FindBy(xpath ="//div[text()='demouser']")WebElement userValue;
	@FindBy(id = "password")WebElement password;
	@FindBy(xpath ="//div[text()='testingisfun99']")WebElement passwordValue;
	@FindBy(id = "login-btn")WebElement loginBtn;
	@FindBy(tagName = "h3")WebElement invalidMessage;
	
	
	//invalid credentials
	@FindBy(xpath = "//div[@id=\"username\"]//div//div//div//div//input")WebElement inUname;
	@FindBy(xpath = "//div[contains(@id,'react-select-')]")WebElement pickUname;
	@FindBy(xpath = "//div[@id='password']//div//div//div//div//input")WebElement inPwd;
	@FindBy(xpath = "//div[contains(@id,'react-select-')]")WebElement pickPwd;
	@FindBy(tagName = "h3")WebElement invalidUserMsg; 
	
	
	//All products
	@FindBy(className = "shelf-item__title")List<WebElement> allProducts;

	//Sort Product
	@FindBy(xpath = "//div[@class='sort']//select")WebElement sort;
	
	
	
	
	//Methods
	
	public void signIn() {
		signIn.click();
	}
	
	public String validLogin() {
		
		userName.click();
		userValue.click();
		
		password.click();
		passwordValue.click();
		loginBtn.click();
		
		return driver.getCurrentUrl();
		
	}
	
	public String invalidLogin() {
		
		inUname.sendKeys("Ankita");
		pickUname.click();
		inPwd.sendKeys("password");
		pickPwd.click();
		loginBtn.click();

		return invalidUserMsg.getText();
		
	}
	
	public String blankLogin() {
		
		loginBtn.click();
		String msg = invalidMessage.getText();
		return msg;
	}
	
	public void signOut() {
		signIn.click();
	}
	
	public int getAllProducts() {
		System.out.println("Total available products are: " + allProducts.size() );
		
		for(WebElement all : allProducts) {
			System.out.println(all.getText());
		}
		
		return allProducts.size();
	}
	
	public void productSorting() {
		Select filter = new Select(sort);
		List<WebElement> allOptions = filter.getOptions();
		
		//printing all the filter options
		for(WebElement a :allOptions) {
			System.out.println(a.getText());
		}
		
		//Filtering as per the available filters
		filter.selectByValue("lowestprice");
		filter.selectByVisibleText("Highest to lowest");		
		
	}
	
}

//u- (//div[contains(@id,'react-select-2-option-')])[1]
//p - (//div[contains(@id,'react-select-3-option-')])[1]
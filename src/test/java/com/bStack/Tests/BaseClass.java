package com.bStack.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.bStack.Pages.CartPage;
import com.bStack.Pages.CheckoutPage;
import com.bStack.Pages.LoginPage;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
	public static WebDriver driver;
	public static LoginPage lp;
	public static CartPage cp;
	public static CheckoutPage ct;
	

  @BeforeSuite
  public void launchApp() {
	  //Launching Browser
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	  driver.get("https://bstackdemo.com/");
	  
	  lp = new LoginPage(driver);
	  cp = new CartPage(driver);
	  ct = new CheckoutPage(driver);
  }

  @AfterSuite
  public void closeApp() {
	  //driver.close();
  }

}

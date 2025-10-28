package com.bStack.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bStack.Utils.Utility;

@Listeners(com.bStack.TestListeners.ExtentITestNGListeners.class)

public class CartPageTestCase extends BaseClass {
	@BeforeClass
	public void login() {
		lp.validLogin();
	}
	
  @Test(priority = 1 )
  public void addOneProduct() {
	  cp.addToCart();
  }
  
  @Test(priority = 2)
  public void addMultipleProducts() throws InterruptedException {
	  Thread.sleep(2000);
	  int bagCount = cp.addMultipleItems();
	  
	  Assert.assertEquals(bagCount, 5);
	  System.out.println("Test Passed: Total items in the bag are: " + bagCount);

	  String bagPrice = cp.cartAmount();
	  Assert.assertTrue(bagPrice.contains("$ 4195.00"), "Test Failed: Amount not matched");
	  System.out.println("Test Passed: Total amount is: " +bagPrice); 
	  
  }
  
  @Test(priority = 3)
  public void removeFromCart() {
	  cp.removeItem(2);
  }
  
}

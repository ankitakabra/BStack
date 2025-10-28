package com.bStack.Tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bStack.Utils.Utility;

@Listeners(com.bStack.TestListeners.ExtentITestNGListeners.class)


public class CheckoutTestCase extends BaseClass{
	
	String parentID;
	
	@BeforeClass
	
	public void getWindowDetails() {
		parentID = driver.getWindowHandle();
		System.out.println("Parent window handle is: "+ parentID);
	}
	
	
	 @Test(priority = 1)
	  public void placeOrder() {
		 
		  int cartCount = cp.getAllCartItems();  
		  System.out.println("\n Cart count before checkout: " + cartCount);
		    
		  String actMsg = ct.checkoutProcess();
		  
		  Assert.assertTrue(actMsg.equals("Your Order has been successfully placed."), "TestCase Failed: No success Message found ");
		  System.out.println("\n TestCase Passed: Order placed.!!");
		  
		  ct.orderDetails();
		 Utility.captureScreenshot(driver, "Receipt");
		  
	  }
	  
	  @Test(priority =2)
	  public void negativeCheckout() {
		  if(!(driver.getWindowHandle()==parentID)) {
			  System.out.println("\nYou have switched to Parent window");
			  driver.switchTo().window(parentID);
			  ct.emptyBag();
		  }
		  else {
			  System.out.println("\n You are already in the Parent window.");

			  ct.emptyBag();
		  }
		 
		  
		  
	  }
}

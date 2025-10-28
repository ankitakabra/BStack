package com.bStack.Tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.bStack.TestListeners.ExtentITestNGListeners.class)

public class LoginPageTestCase extends BaseClass {

 //When login fields are valid
	
  @Test(priority=1)
  public void loginWithValidCredentials() {
	  lp.signIn();
	  String actUrl = lp.validLogin();
	  Assert.assertTrue(actUrl.contains("signin"), "Test Failed: Invalid credentials");
	  System.out.println("TestCase Passed : Logged successfully.!!");	   
  }
  
  @Test(priority =2)
  public void getAllProductsList() {
	  int actTotalProd = lp.getAllProducts();
	  
	  Assert.assertEquals(actTotalProd, 25);
	  System.out.println("TestCase Passed: Total products are 25");
  }
  
  @Test(priority = 3)
  public void filters() {
	  lp.productSorting();
	  lp.signOut();

  }
  
  //When login fields are invalid

   @Test(priority = 4)
   public void loginWithInvalidCredentials() {
	   lp.signIn();
	   String msg = lp.invalidLogin();
	   
	  Assert.assertTrue(msg.contains("Invalid Username"), "Test Failed: Invalid credentials");
	  System.out.println("TestCase Passed : Error message is: " + msg);
	  
  }
   
  //When login fields are blank
   
  @Test(priority=5)
  public void blankLogin() {
	  driver.navigate().refresh();
	  String actMsg = lp.blankLogin();
	  Assert.assertTrue(actMsg.equals("Invalid Username"), "TestCase Failed");
	  System.out.println("TestCase Passed : Error message is: " + actMsg);
  }
  
}



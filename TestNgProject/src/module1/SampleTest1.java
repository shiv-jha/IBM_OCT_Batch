package module1;

import org.testng.annotations.Test;

import common.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SampleTest1 extends BaseClass {
	
  @Parameters({"seachItem"})
  @Test(priority = 2,groups = {"smoke"})
  public void searchItem(String item) {
	  driver.findElement(By.name("search")).sendKeys(item);
  }
  
  //@Ignore
  @Test(priority = 1,groups = {"regression","smoke"})
  public void test2() {
	  System.out.println("test2");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before method ");
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method ");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class ");
  }
  @AfterClass
  public void afterClass() {
	  System.out.println("after class ");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test ");
  }
  @AfterTest
  public void afterTest() {
	  System.out.println("after test ");
  }
 
}

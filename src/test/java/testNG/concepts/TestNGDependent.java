package testNG.concepts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDependent {

	// In TestNG we can make tests dependent on each other.
	// for exmaple if Open browser Test case is failed, Sign in test case will not
	// execute.
	// It means test case which is depended on main test case will only execute if
	// main test case is pass.

	@Test (groups = {"test"})
	public void test_OpenBrowser() {
		
		Assert.assertTrue(true);
		
		System.out.println("this is OpenBrowser Test");

	}

	@Test(dependsOnMethods = { "test_OpenBrowser" })
	public void test_NavigateToURL() {
		
		System.out.println("This method will be executed if OpenBrowser Test is passed");
		Assert.assertTrue(true);

	}
	
	@Test (dependsOnMethods = {"test_NavigateToURL"} , dependsOnGroups = {"test"})
	public void test_SignINtoApplication() {
		System.out.println("This method will be executed if the two other test case or methods are executed successfully");
	}

	
	
}

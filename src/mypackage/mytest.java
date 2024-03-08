package mypackage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mytest extends parameter {



	@BeforeTest
	public void mybeforetest() {
    openWebSit();
		

	}

	@Test(priority=1,description = "Sad Scenario")
	public void logIn() throws InterruptedException {
		loginSadSCenario();
	}  
	
	
	
	 @Test(priority=2)
	    public void testPasswordReset() throws InterruptedException {
	        
	        String password = getPassword("dummyPassword");
	        System.out.println(password);
	      assertEquals("rahulshettyacademy", password, "Expected password does not match actual password.");
	    }
	
	 
	 @Test(priority=3,description = "Happy Scenario log in")
		public void logInSuccess() throws InterruptedException {  
		 logIn();
	 }
	
	@Test(priority=4,description = " lof out function and cheack log out account")
	public void logOutTest() throws InterruptedException {
		logOut();
	}
	
	

	@AfterTest
	public void myAfterTest() {

	}

}

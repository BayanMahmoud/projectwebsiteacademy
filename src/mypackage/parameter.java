package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class parameter {
	WebDriver driver = new ChromeDriver();

	String name = "rahul";

	public void openWebSit() {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	}

	public void loginSadSCenario() throws InterruptedException {

		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("ASD123asd");

		driver.findElement(By.className("submit")).click();

		Thread.sleep(3000);
		String Msg = driver.findElement(By.cssSelector(".error")).getText();
		Assert.assertEquals(Msg, "* Incorrect username or password");

	}

	public String getPassword(String pass) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//a[normalize-space()='Forgot your password?']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Bayan");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("bb819@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("bana487@gmail.com");

		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("077463854");

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(4000);
		String passText = driver.findElement(By.cssSelector(".infoMsg")).getText();

		// System.out.println(passText);
		// Please use temporary password 'rahulshettyacademy' to Login.
		String[] arr = passText.split("'");
		String password = arr[1];
		return password;
	}

	public void logIn() throws InterruptedException {

		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.cssSelector("#chkboxOne")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(3000);

		String actualhelloMsg = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertEquals(actualhelloMsg, "Hello" + " " + name + ",");

		String actualSuccesMsg = driver
				.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText();
		Assert.assertEquals(actualSuccesMsg, "You are successfully logged in.");

	}

	public void logOut() throws InterruptedException {

		driver.findElement(By.cssSelector(".logout-btn")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://rahulshettyacademy.com/locatorspractice/");
	}

}

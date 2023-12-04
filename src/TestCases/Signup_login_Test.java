package TestCases;

import org.openqa.selenium.*;
import org.testng.annotations.*;

public class Signup_login_Test extends Parameters {
	@BeforeTest
	public void setup() {
		driver.get(magento_url);
	}

	@Test(priority = 1)
	public void signup() throws InterruptedException {
		driver.get(signup_page);
		WebElement first_name_input = driver.findElement(By.id("firstname"));
		WebElement last_name_input = driver.findElement(By.id("lastname"));
		WebElement email_input = driver.findElement(By.id("email_address"));
		WebElement password_input = driver.findElement(By.id("password"));
		WebElement confirm_password = driver.findElement(By.id("password-confirmation"));
		WebElement Signup_button = driver.findElement(By.className("submit"));

		// Fill the input fields
		first_name_input.sendKeys(firstName);
		last_name_input.sendKeys(lastName);
		email_input.sendKeys(random_email);
		password_input.sendKeys(password);
		confirm_password.sendKeys(password);
		Signup_button.click();
		Thread.sleep(2000);
		
		//Assertion
		String welcome_msg = driver.findElement(By.xpath("//div[@class='panel header']")).getText();
		softassert.assertEquals(welcome_msg.contains("Welcome"), true , "Validation the signup process");
		softassert.assertAll();
	}

	@Test(priority = 2)
	public void logout() throws InterruptedException {
		driver.get(logout_page);
		Thread.sleep(7000);
		//Assertion
		softassert.assertEquals(driver.getCurrentUrl(), magento_url,"Validation of the website url after the logout process");
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void login() throws InterruptedException {
		driver.get(login_page);
		WebElement email = driver.findElement(By.id("email"));
		WebElement password_input = driver.findElement(By.id("pass"));
		WebElement login_button = driver.findElement(By.id("send2"));
		email.sendKeys(random_email);
		password_input.sendKeys(password);
		login_button.click();
		Thread.sleep(2000);
		//Assertion
		String welcome_msg_login = driver.findElement(By.className("logged-in")).getText();
		softassert.assertEquals(welcome_msg_login.contains("Welcome"), true , "Validation the login process");
		softassert.assertAll();
	}

	@AfterTest
	public void postTest() {

	}
}

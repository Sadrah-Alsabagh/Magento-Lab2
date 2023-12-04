package TestCases;

import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Parameters {
	WebDriver driver = new ChromeDriver();
	String magento_url = "https://magento.softwaretestingboard.com/";
	String signup_page = "https://magento.softwaretestingboard.com/customer/account/create/";
	String logout_page = "https://magento.softwaretestingboard.com/customer/account/logout/";
	String login_page = "https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/";
	String[] firstNames = { "Sedra", "Elham", "Maisa", "Raneem" };
	String[] lastNames = { "Ahmed", "Omar", "Anas", "Emad" };

	Random rand = new Random();
	int random_first_names = rand.nextInt(firstNames.length);
	int random_last_names = rand.nextInt(lastNames.length);
	int random_num_for_email = rand.nextInt(999);
	String firstName = firstNames[random_first_names];
	String lastName = lastNames[random_last_names];

	String random_email = firstName + lastName + random_num_for_email + "@gmail.com";
	String password ="SDR@123s";
	
	SoftAssert softassert = new SoftAssert();
}

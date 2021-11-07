package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private By usernameInput = By.xpath(".//input[@name='email']");
	private By passwordInput = By.xpath(".//input[@name='pass']");
	private By LogInButton = By.xpath(".//button[@type='submit']");

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open Facebook */
	public void openPage(String pageURL) {
		log.info("Opening page: " + pageURL);

		openUrl(pageURL);
		log.info("Page opened!");
	}

	/** Enter username , password and click on LogIn button */
	public HomePage loginFB(String username, String password) {
		log.info("Entering username");
		type(username, usernameInput);

		log.info("Entering password");
		type(password, passwordInput);

		log.info("Clicking LogIn button");
		click(LogInButton);

		return new HomePage(driver, log);
	}

}
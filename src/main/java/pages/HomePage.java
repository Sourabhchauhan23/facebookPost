package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
	
	private By whatsOnYourMind = By.xpath(".//div[@aria-label='Create a post']/div[1]/div/div[1]");
	private By post = By.xpath(".//div[@aria-label='Post']");
		

	public HomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/* Posting Status of facebook wall */
	public void postStatus(String status) {
		click(whatsOnYourMind);
		waitForVisibilityOf(post, 5);
		Actions action = new Actions(driver);
		action.sendKeys(status).build().perform();
		log.info("Typing Status");
		click(post);
		log.info("Posting Status");
			
	}

}
package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;

public class DigitalPageObject extends BasePage {
	public WebDriver driver;

	public DigitalPageObject(WebDriver driver) {
		this.driver = driver;
	}

}

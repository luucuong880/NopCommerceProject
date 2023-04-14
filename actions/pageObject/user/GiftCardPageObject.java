package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;

public class GiftCardPageObject extends BasePage {
	public WebDriver driver;

	public GiftCardPageObject(WebDriver driver) {
		this.driver = driver;
	}

}

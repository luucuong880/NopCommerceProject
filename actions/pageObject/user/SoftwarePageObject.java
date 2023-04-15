package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;

public class SoftwarePageObject extends BasePage {
	public WebDriver driver;

	public SoftwarePageObject(WebDriver driver) {
		this.driver = driver;
	}

}

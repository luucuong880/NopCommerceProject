package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;

public class ElectronicsPageObject extends BasePage {
	public WebDriver driver;

	public ElectronicsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}

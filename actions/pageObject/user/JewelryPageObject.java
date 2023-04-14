package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;

public class JewelryPageObject extends BasePage {
	public WebDriver driver;

	public JewelryPageObject(WebDriver driver) {
		this.driver = driver;
	}

}

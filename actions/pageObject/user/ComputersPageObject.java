package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;

public class ComputersPageObject extends BasePage {
	public WebDriver driver;

	public ComputersPageObject(WebDriver driver) {
		this.driver = driver;
	}

}

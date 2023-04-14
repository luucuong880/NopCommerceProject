package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;

public class BooksPageObject extends BasePage {
	public WebDriver driver;

	public BooksPageObject(WebDriver driver) {
		this.driver = driver;
	}

}

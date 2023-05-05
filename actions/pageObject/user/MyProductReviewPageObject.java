package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;

public class MyProductReviewPageObject extends BasePage {
	WebDriver driver;

	public MyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

}

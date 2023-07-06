package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import pageUI.wordpress.AdminPostAddnewPageUI;

public class AdminPostAddnewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddnewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddnewPostTitle(String postTitleValue) {
		waitForElementVisible(driver, AdminPostAddnewPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddnewPageUI.TITLE_TEXTBOX, postTitleValue);
	}

	public void enterToAddnewPostBody(String postBodyValue) {
		waitForElementClickable(driver, AdminPostAddnewPageUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddnewPageUI.BODY_BUTTON);

		waitForElementVisible(driver, AdminPostAddnewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddnewPageUI.BODY_TEXTBOX, postBodyValue);
	}

	public void enterToEditPostBody(String postBodyValue) {
		waitForElementClickable(driver, AdminPostAddnewPageUI.BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddnewPageUI.BODY_TEXTBOX);

		waitForElementVisible(driver, AdminPostAddnewPageUI.BODY_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminPostAddnewPageUI.BODY_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddnewPageUI.BODY_TEXTBOX, postBodyValue);
	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddnewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddnewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String postPublishMessage) {
		waitForElementVisible(driver, AdminPostAddnewPageUI.PUBLISHED_OR_UPDATED_MESSAGE, postPublishMessage);
		return isElementDisplayed(driver, AdminPostAddnewPageUI.PUBLISHED_OR_UPDATED_MESSAGE, postPublishMessage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneraterManager.getAdminPostSearchPage(driver);
	}
}

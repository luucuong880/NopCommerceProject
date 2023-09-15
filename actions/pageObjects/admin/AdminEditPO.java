package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import nopcommerce.admin.BasePage;
import nopcommerce.admin.PageGeneraterManager;
import pageUIs.admin.AdminEditPageUI;

public class AdminEditPO extends BasePage {
	private WebDriver driver;

	public AdminEditPO(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String string) {
		waitForElementVisible(driver, AdminEditPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminEditPageUI.EMAIL_TEXTBOX, string);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AdminEditPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminEditPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AdminEditPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AdminEditPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToDayOfBirthTextbox(String string) {
		waitForElementVisible(driver, AdminEditPageUI.DAY_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, AdminEditPageUI.DAY_OF_BIRTH_TEXTBOX, string);
	}

	public void clickToDeleteButton() {
		scrollToElement(driver, AdminEditPageUI.GET_TEXT);
		waitForElementClickable(driver, AdminEditPageUI.DELETE_BUTTON);
		clickToElement(driver, AdminEditPageUI.DELETE_BUTTON);
		sleepInSecond(3);
	}

	public void inputToCompanyTextbox(String company) {
		waitForElementVisible(driver, AdminEditPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AdminEditPageUI.COMPANY_TEXTBOX, company);
	}

	public void inputToAdminCommentTextbox(String string) {
		waitForElementVisible(driver, AdminEditPageUI.ADMIN_COMMENT_TEXTBOX);
		sendkeyToElement(driver, AdminEditPageUI.ADMIN_COMMENT_TEXTBOX, string);
	}

	public AdminCustomerInfoPO clickToSaveButton() {
		waitForElementClickable(driver, AdminEditPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminEditPageUI.SAVE_BUTTON);
		sleepInSecond(3);
		return PageGeneraterManager.getAdminCustomerInfoPage(driver);
	}

	public boolean getSuccessMessage() {
		waitForElementVisible(driver, AdminEditPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, AdminEditPageUI.SUCCESS_MESSAGE);
	}

	public String getCustomerRoleInDataTable() {
		waitForElementVisible(driver, AdminEditPageUI.CUSTOMER_ROLE_AT_DATA_TABLE);
		return getElementText(driver, AdminEditPageUI.CUSTOMER_ROLE_AT_DATA_TABLE);
	}

	public void clickToAddNewAddressButton() {
		scrollToElement(driver, AdminEditPageUI.ADD_NEW_ADDRESS_BUTTON);
		waitForElementClickable(driver, AdminEditPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AdminEditPageUI.ADD_NEW_ADDRESS_BUTTON);
		sleepInSecond(4);
	}

	public void clickToAddNewAddressLink() {
		waitForElementClickable(driver, AdminEditPageUI.ADD_NEW_ADDRESS_LINK);
		clickToElement(driver, AdminEditPageUI.ADD_NEW_ADDRESS_LINK);
	}

	public AdminAddNewAddressPO openAddNewAddressPage() {
		sleepInSecond(3);
		clickToAddNewAddressButton();
		clickToAddNewAddressLink();
		return PageGeneraterManager.getAdminAddNewAddressPage(driver);
	}

	public boolean isFirstNameAddressDisplayed() {
		scrollToElement(driver, AdminEditPageUI.GET_TEXT);
		waitForElementVisible(driver, AdminEditPageUI.FIRST_NAME_ADDRESS);
		return isElementDisplayed(driver, AdminEditPageUI.FIRST_NAME_ADDRESS);
	}

	public boolean isLastNameAddressDisplayed() {
		scrollToElement(driver, AdminEditPageUI.GET_TEXT);
		waitForElementVisible(driver, AdminEditPageUI.LAST_NAME_ADDRESS);
		return isElementDisplayed(driver, AdminEditPageUI.LAST_NAME_ADDRESS);
	}

	public boolean isPhoneNumberAddressDisplayed() {
		scrollToElement(driver, AdminEditPageUI.GET_TEXT);
		waitForElementVisible(driver, AdminEditPageUI.PHONE_NUMBER_ADDRESS);
		return isElementDisplayed(driver, AdminEditPageUI.PHONE_NUMBER_ADDRESS);
	}

	public boolean isFaxNumberAddressDisplayed() {
		scrollToElement(driver, AdminEditPageUI.GET_TEXT);
		waitForElementVisible(driver, AdminEditPageUI.FAX_NUMBER_ADDRESS);
		return isElementDisplayed(driver, AdminEditPageUI.FAX_NUMBER_ADDRESS);
	}

	public boolean isAddressDisplayed() {
		scrollToElement(driver, AdminEditPageUI.GET_TEXT);
		waitForElementVisible(driver, AdminEditPageUI.ADDRESS);
		return isElementDisplayed(driver, AdminEditPageUI.ADDRESS);
	}

	public AdminAddNewAddressPO clickToEditButton() {
		waitForElementClickable(driver, AdminEditPageUI.EDIT_BUTTON);
		clickToElement(driver, AdminEditPageUI.EDIT_BUTTON);
		sleepInSecond(3);
		return PageGeneraterManager.getAdminAddNewAddressPage(driver);
	}

	public void acceptAlertMessage() {
		acceptAlert(driver);
	}

	public String getDataTableMessage() {
		waitForElementVisible(driver, AdminEditPageUI.DATA_MESSAGE);
		return getElementText(driver, AdminEditPageUI.DATA_MESSAGE);
	}
}

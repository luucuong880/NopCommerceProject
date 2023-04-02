package pageObject.user;

import org.openqa.selenium.WebDriver;

import nopcommerce.user.BasePage;
import pageUI.user.DesktopPageUI;

public class DesktopPageObject extends BasePage {
	private WebDriver driver;

	public DesktopPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToBuildOwnComputer() {
		waitForElementClickable(driver, DesktopPageUI.BUILD_OWN_COMPUTER);
		clickToElement(driver, DesktopPageUI.BUILD_OWN_COMPUTER);
	}

	public void clickToLenovoPC() {
		waitForElementClickable(driver, DesktopPageUI.LENOVO_BUTTON);
		clickToElement(driver, DesktopPageUI.LENOVO_BUTTON);
	}

	public void clickToAddWishListButton() {
		waitForElementClickable(driver, DesktopPageUI.WISH_LIST_BUTTON);
		clickToElement(driver, DesktopPageUI.WISH_LIST_BUTTON);
	}

	public String getAddWislistSuccessMessage() {
		waitForElementVisible(driver, DesktopPageUI.ADD_WISH_LIST_SUCCESS_MESSAGE);
		return getElementText(driver, DesktopPageUI.ADD_WISH_LIST_SUCCESS_MESSAGE);
	}

	public void clickToCloseSuccessMessage() {
		waitForElementClickable(driver, DesktopPageUI.CLOSE_SUCCESS_MESSAGE);
		clickToElement(driver, DesktopPageUI.CLOSE_SUCCESS_MESSAGE);
	}

	public void waitForSuccessMessageInvisible() {
		waitForElementInVisible(driver, DesktopPageUI.ADD_WISH_LIST_SUCCESS_MESSAGE);
	}

	public void clickToCompareButtonBOC() {
		waitForElementClickable(driver, DesktopPageUI.COMPARE_BOC_BUTTON);
		clickToElement(driver, DesktopPageUI.COMPARE_BOC_BUTTON);
	}

	public void clickToCompareButtonLenovo() {
		waitForElementClickable(driver, DesktopPageUI.COMPARE_LENOVO_BUTTON);
		clickToElement(driver, DesktopPageUI.COMPARE_LENOVO_BUTTON);
	}

	public String getProductCompareMessage() {
		waitForElementVisible(driver, DesktopPageUI.PRODUCT_COMPARE_MESSAGE);
		return getElementText(driver, DesktopPageUI.PRODUCT_COMPARE_MESSAGE);
	}

	public void waitSeconds() {
		sleepInSecond(2);
	}

	public void processorSelect(String string) {
		waitForElementVisible(driver, DesktopPageUI.PROCESSOR);
		selectItemInCustomDropdown(driver, DesktopPageUI.PROCESSOR, "xpath=//option", string);
	}

	public void ramSelect(String string) {
		waitForElementVisible(driver, DesktopPageUI.RAM);
		selectItemInCustomDropdown(driver, DesktopPageUI.RAM, "xpath=//option", string);
	}

	public void HDD400gbCheck() {
		waitForElementVisible(driver, DesktopPageUI.HDD_400GB);
		checkToDefaultCheckboxOrRadio(driver, DesktopPageUI.HDD_400GB);
	}

	public void vistaHomeCheck() {
		waitForElementVisible(driver, DesktopPageUI.VISTA_HOME);
		checkToDefaultCheckboxOrRadio(driver, DesktopPageUI.VISTA_HOME);
	}

	public void softwareMOCheck() {
		waitForElementVisible(driver, DesktopPageUI.SOFT_WARE_MO);
		checkToDefaultCheckboxOrRadio(driver, DesktopPageUI.SOFT_WARE_MO);
	}

	public void softwareARCheck() {
		waitForElementVisible(driver, DesktopPageUI.SOFT_WARE_AR);
		checkToDefaultCheckboxOrRadio(driver, DesktopPageUI.SOFT_WARE_AR);
	}

	public void softwareTCCheck() {
		waitForElementVisible(driver, DesktopPageUI.SOFT_WARE_TC);
		checkToDefaultCheckboxOrRadio(driver, DesktopPageUI.SOFT_WARE_TC);
	}

	public boolean isProcessor2_5Selected() {
		waitForElementVisible(driver, DesktopPageUI.PROCESSOR_2_5);
		return isElementSelected(driver, DesktopPageUI.PROCESSOR_2_5);
	}

	public boolean isProcessor2_2Selected() {
		waitForElementVisible(driver, DesktopPageUI.PROCESSOR_2_2);
		return isElementSelected(driver, DesktopPageUI.PROCESSOR_2_2);
	}

	public boolean isRam8GbSelected() {
		waitForElementVisible(driver, DesktopPageUI.RAM_8GB);
		return isElementSelected(driver, DesktopPageUI.RAM_8GB);
	}

	public boolean isRam4GbSelected() {
		waitForElementVisible(driver, DesktopPageUI.RAM_4GB);
		return isElementSelected(driver, DesktopPageUI.RAM_4GB);
	}

	public boolean isHDD400gbDisplayed() {
		waitForElementVisible(driver, DesktopPageUI.HDD_400GB);
		return isElementDisplayed(driver, DesktopPageUI.HDD_400GB);
	}

	public boolean isHDD320gbDisplayed() {
		waitForElementVisible(driver, DesktopPageUI.HDD_320GB);
		return isElementDisplayed(driver, DesktopPageUI.HDD_320GB);
	}

	public boolean isVistaHomeDisplayed() {
		waitForElementVisible(driver, DesktopPageUI.VISTA_HOME);
		return isElementDisplayed(driver, DesktopPageUI.VISTA_HOME);
	}

	public boolean isSoftwareMODisplayed() {
		waitForElementVisible(driver, DesktopPageUI.SOFT_WARE_MO);
		return isElementDisplayed(driver, DesktopPageUI.SOFT_WARE_MO);
	}

	public boolean isSoftwareARDisplayed() {
		waitForElementVisible(driver, DesktopPageUI.SOFT_WARE_AR);
		return isElementDisplayed(driver, DesktopPageUI.SOFT_WARE_AR);
	}

	public boolean isSoftwareTCDisplayed() {
		waitForElementVisible(driver, DesktopPageUI.SOFT_WARE_TC);
		return isElementDisplayed(driver, DesktopPageUI.SOFT_WARE_TC);
	}

	public String productPrice() {
		waitForElementVisible(driver, DesktopPageUI.PRODUCTS_PRICE);
		return getElementText(driver, DesktopPageUI.PRODUCTS_PRICE);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(driver, DesktopPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, DesktopPageUI.ADD_TO_CART_BUTTON);
	}

	public String getAddCartSuccessMessage() {
		waitForElementVisible(driver, DesktopPageUI.ADD_CART_MESSAGE_SUCCESS);
		return getElementText(driver, DesktopPageUI.ADD_CART_MESSAGE_SUCCESS);
	}

	public boolean isFlyoutCartDisplayed() {
		scrollToElement(driver, DesktopPageUI.SHOPPING_CART_LINK);
		hoverMouseToElement(driver, DesktopPageUI.SHOPPING_CART_LINK);
		waitForElementVisible(driver, DesktopPageUI.FLYOUT_CART);
		return isElementDisplayed(driver, DesktopPageUI.FLYOUT_CART);
	}

	public void HDD320gbCheck() {
		waitForElementVisible(driver, DesktopPageUI.HDD_320GB);
		checkToDefaultCheckboxOrRadio(driver, DesktopPageUI.HDD_320GB);
	}

	public void vistaPremiumCheck() {
		waitForElementVisible(driver, DesktopPageUI.VISTA_PREMIUM);
		checkToDefaultCheckboxOrRadio(driver, DesktopPageUI.VISTA_PREMIUM);
	}

	public void inputToProductQuantity(String string) {
		waitForElementVisible(driver, DesktopPageUI.PRODUCT_QUANTITY_TEXT);
		sendkeyToElement(driver, DesktopPageUI.PRODUCT_QUANTITY_TEXT, string);
	}

	public void clickToUpdateButton() {
		waitForElementClickable(driver, DesktopPageUI.UPDATE_BUTTON);
		clickToElement(driver, DesktopPageUI.UPDATE_BUTTON);
	}

	public void clickToCartButton() {
		waitForElementClickable(driver, DesktopPageUI.CART_BUTTON);
		clickToElement(driver, DesktopPageUI.CART_BUTTON);
	}

	public void softwareARUnCheck() {
		waitForElementVisible(driver, DesktopPageUI.SOFT_WARE_AR);
		uncheckToDefaultCheckbox(driver, DesktopPageUI.SOFT_WARE_AR);
	}

	public void softwareTCUnCheck() {
		waitForElementVisible(driver, DesktopPageUI.SOFT_WARE_TC);
		uncheckToDefaultCheckbox(driver, DesktopPageUI.SOFT_WARE_TC);
	}

}

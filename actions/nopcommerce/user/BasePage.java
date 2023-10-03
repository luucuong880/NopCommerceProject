package nopcommerce.user;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import pageUI.jQuery.uploadFile.BasePageJQueryUI;
import pageUI.user.BasePageUI;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Set<Cookie> getBrowserCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.accept();
	}

	public void cancleAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.className(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}

	public String getDynamicXpath(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
	}

	public WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		this.getWebElement(driver, locatorType).click();
		if (driver.toString().contains("internet explorer")) {
			sleepInSecond(3);
		}
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		this.getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
		if (driver.toString().contains("internet explorer")) {
			sleepInSecond(3);
		}
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}

	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType, String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(2);

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(2);
				item.click();
				break;
			}

		}
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem, String... dynamicValues) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(2);

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(2);
				item.click();
				break;
			}

		}
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}

	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String getHexaColorByRgbaColor(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}

	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkToDefaultCheckboxOrRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			// Tìm thấy Element:
			// Case 1 : Displayed - trả về true
			// Case 2 : Undisplayed - trả về false
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			// Case 3 : Undisplayed - trả về false
			return false;
		}

	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}

	public void overrideImplicitTimeout(WebDriver driver, Duration timeout) {
		driver.manage().timeouts().implicitlyWait(timeout);
	}

	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		overrideImplicitTimeout(driver, Duration.ofSeconds(30));
		List<WebElement> elements = getListWebElement(driver, locatorType);
		overrideImplicitTimeout(driver, Duration.ofSeconds(30));
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementUndisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		overrideImplicitTimeout(driver, Duration.ofSeconds(30));
		List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		overrideImplicitTimeout(driver, Duration.ofSeconds(30));
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementEnable(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementEnable(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locatorType, String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToFrameIframe(WebDriver driver, String locatorType, String... dynamicValues) {
		driver.switchTo().frame(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues))).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void highlightElement(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void clickToElementByJS(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public String getElementValueByJsXpath(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath=", "");
		return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + xpathLocator + "\"), document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public WebElement getShadowDom(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = (WebElement) jsExecutor.executeScript("arguments[0].shadowRoot;", getWebElement(driver, locatorType));
		return element;
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return status;
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementInVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementInVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}

	public void waitForAllElementInVisible(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = System.getProperty(".dir") + "\\uploadFiles\\";
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageJQueryUI.UPLOAD_FILE).sendKeys(fullFileName);
	}

	public BasePage openPageAtMyAccountByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getPageGeneratorManager().getCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorManager.getPageGeneratorManager().getAddressPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getPageGeneratorManager().getMyProductReviewPage(driver);
		case "Reward points":
			return PageGeneratorManager.getPageGeneratorManager().getRewardPointPage(driver);
		case "Change password":
			return PageGeneratorManager.getPageGeneratorManager().getChangePasswordPage(driver);
		case "Orders":
			return PageGeneratorManager.getPageGeneratorManager().getOrderPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My Account are.");
		}

	}

	public BasePage openMenuPage(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_AT_TOP_MENU_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_AT_TOP_MENU_AREA, pageName);
		return PageGeneratorManager.getPageGeneratorManager().getMenuPage(driver);
	}

	public BasePage openPageAtHeaderLinks(WebDriver driver, String pageLink) {
		waitForElementClickable(driver, BasePageUI.HEADER_LINKS, pageLink);
		clickToElement(driver, BasePageUI.HEADER_LINKS, pageLink);
		switch (pageLink) {
		case "ico-register":
			return PageGeneratorManager.getPageGeneratorManager().getRegisterPage(driver);
		case "ico-login":
			return PageGeneratorManager.getPageGeneratorManager().getLoginPage(driver);
		case "ico-wishlist":
			return PageGeneratorManager.getPageGeneratorManager().getWishListPage(driver);
		case "ico-cart":
			return PageGeneratorManager.getPageGeneratorManager().getCartPage(driver);
		case "ico-account":
			return PageGeneratorManager.getPageGeneratorManager().getCustomerInfoPage(driver);
		case "ico-logout":
			return PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);
		default:
			throw new RuntimeException("Invalid page Links at Header are.");
		}
	}

	public BasePage openFooterPage(WebDriver driver, String pageLink) {
		waitForElementClickable(driver, BasePageUI.FOOTER_LINKS, pageLink);
		clickToElement(driver, BasePageUI.FOOTER_LINKS, pageLink);
		return PageGeneratorManager.getPageGeneratorManager().getFootersPage(driver);
	}

	public boolean isPageTitleByTextDisplayed(WebDriver driver, String textValue) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_PAGE_TITLE, textValue);
		return isElementDisplayed(driver, BasePageUI.DYNAMIC_PAGE_TITLE, textValue);
	}

	public void clickButtonByText(WebDriver driver, String textValue) {
		waitForElementVisible(driver, BasePageUI.BUTTON_TEXT, textValue);
		clickToElement(driver, BasePageUI.BUTTON_TEXT, textValue);
	}

	public void clickButtonByClass(WebDriver driver, String classValue) {
		waitForElementVisible(driver, BasePageUI.BUTTON_DYNAMIC, classValue);
		clickToElement(driver, BasePageUI.BUTTON_DYNAMIC, classValue);
	}

	public void hoverToHeaderLinks(WebDriver driver, String classValue) {
		hoverMouseToElement(driver, BasePageUI.HEADER_LINKS, classValue);
	}

	public boolean isButtonDisplayed(WebDriver driver, String textValue) {
		waitForElementVisible(driver, BasePageUI.BUTTON_TEXT, textValue);
		return isElementDisplayed(driver, BasePageUI.BUTTON_TEXT, textValue);
	}

	public boolean isButtonUnDisplayed(WebDriver driver, String textValue) {
		waitForElementInVisible(driver, BasePageUI.BUTTON_TEXT, textValue);
		return isElementUndisplayed(driver, BasePageUI.BUTTON_TEXT, textValue);
	}

	@Step("Get Error Message At Fields")
	public String getErrorMessageWithDynamicValue(WebDriver driver, String errorMessage) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, errorMessage);
		return getElementText(driver, BasePageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, errorMessage);
	}

	@Step("Click to Radio Button with value is {0}")
	public void selectToDropdownByName(WebDriver driver, String dropdownAttributeName, String itemValue) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		selectItemInDefaultDropdown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropdownAttributeName);
		sleepInSecond(2);
	}

	public String getItemSelected(WebDriver driver, String dropdownAttributeName) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
		return getSelectedItemDefaultDropdown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownAttributeName);
	}

	public void inputToTextboxByID(WebDriver driver, String textID, String textValue) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textID);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textValue, textID);
	}

	@Step("Click to Radio Button with value is {0}")
	public void checkToRadioButtonByID(WebDriver driver, String radioButtonByID) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, radioButtonByID);
		checkToDefaultCheckboxOrRadio(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, radioButtonByID);
	}

	public void clickToProductByText(WebDriver driver, String textValue) {
		waitForElementClickable(driver, BasePageUI.PRODUCT_BY_DYNAMICS_TEXT, textValue);
		checkToDefaultCheckboxOrRadio(driver, BasePageUI.PRODUCT_BY_DYNAMICS_TEXT, textValue);
	}

	public boolean isProductReviewDisplayed(WebDriver driver, String textValue) {
		waitForElementVisible(driver, BasePageUI.PRODUCT_BY_DYNAMICS_TEXT, textValue);
		return isElementDisplayed(driver, BasePageUI.PRODUCT_BY_DYNAMICS_TEXT, textValue);
	}

	public boolean isProductReviewUnDisplayed(WebDriver driver, String textValue) {
		waitForElementInVisible(driver, BasePageUI.PRODUCT_BY_DYNAMICS_TEXT, textValue);
		return isElementUndisplayed(driver, BasePageUI.PRODUCT_BY_DYNAMICS_TEXT, textValue);
	}

	public void waitForAjaxLoadingUndisplayed(WebDriver driver) {
		waitForElementInVisible(driver, BasePageUI.AJAX_LOADING_ICON);
	}

	public String getSuccessMessage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.SUCCESS_MESSAGE);
		return getElementText(driver, BasePageUI.SUCCESS_MESSAGE);
	}

	public String getPageTitleText(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.PAGE_TITLE_MESSAGE);
		return getElementText(driver, BasePageUI.PAGE_TITLE_MESSAGE);
	}

	public String getHeaderText(WebDriver driver, String classValue) {
		waitForElementVisible(driver, BasePageUI.HEADER_LINKS, classValue);
		return getElementText(driver, BasePageUI.HEADER_LINKS, classValue);
	}

	public String getMessageByDynamicsClass(WebDriver driver, String classValue) {
		waitForElementVisible(driver, BasePageUI.MESSAGE_DYNAMIC_BY_CLASS, classValue);
		return getElementText(driver, BasePageUI.MESSAGE_DYNAMIC_BY_CLASS, classValue);
	}

	public boolean isMessageByDynamicsClassDisplayed(WebDriver driver, String classValue) {
		waitForElementVisible(driver, BasePageUI.MESSAGE_DYNAMIC_BY_CLASS, classValue);
		return isElementDisplayed(driver, BasePageUI.MESSAGE_DYNAMIC_BY_CLASS, classValue);
	}

	public void closeSuccessMessage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CLOSE_BUTTON);
		clickToElement(driver, BasePageUI.CLOSE_BUTTON);
		sleepInSecond(2);
	}

	public String getNoDataMessage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.NO_DATA_MESSAGE);
		return getElementText(driver, BasePageUI.NO_DATA_MESSAGE);
	}

	public String getTextboxValueByID(WebDriver driver, String textboxID) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}

	public Object getProductSize(WebDriver driver) {
		waitForElementVisible(driver, BasePageUI.PRODUCT_SIZE);
		return getElementSize(driver, BasePageUI.PRODUCT_SIZE);
	}

	public boolean isProductNameSortByAscending(WebDriver driver) {
		ArrayList<String> productUIList = new ArrayList<String>();

		List<WebElement> productNameText = getListWebElement(driver, BasePageUI.PRODUCT_SIZE);

		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		ArrayList<String> productSortList = new ArrayList<String>();

		for (String product : productUIList) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);

		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending(WebDriver driver) {
		ArrayList<String> productUIList = new ArrayList<String>();

		List<WebElement> productNameText = getListWebElement(driver, BasePageUI.PRODUCT_SIZE);

		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		ArrayList<String> productSortList = new ArrayList<String>();

		for (String product : productUIList) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);

		Collections.reverse(productSortList);

		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending(WebDriver driver) {
		ArrayList<Float> productUIList = new ArrayList<Float>();

		List<WebElement> productPriceText = getListWebElement(driver, BasePageUI.PRODUCT_PRICE);

		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		ArrayList<Float> productSortList = new ArrayList<Float>();

		for (Float product : productUIList) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);

		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending(WebDriver driver) {
		ArrayList<Float> productUIList = new ArrayList<Float>();

		List<WebElement> productPriceText = getListWebElement(driver, BasePageUI.PRODUCT_PRICE);

		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		ArrayList<Float> productSortList = new ArrayList<Float>();

		for (Float product : productUIList) {
			productSortList.add(product);
		}

		Collections.sort(productSortList);

		Collections.reverse(productSortList);

		return productSortList.equals(productUIList);
	}

}

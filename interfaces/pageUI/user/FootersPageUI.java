package pageUI.user;

public class FootersPageUI {

	public static final String SEARCH_TEXTBOX = "id=q";
	public static final String SEARCH_BUTTON = "class=search-button";
	public static final String ADVANCED_SEARCH = "xpath=//input[@id='advs']";
	public static final String CATEGORY = "xpath=//select[@id='cid']";
	public static final String CATEGORY_SELECTED = "xpath=//select[@id='cid']//option[text()='Computers']";
	public static final String AUTOMATICALLY_SEARCH = "xpath=//input[@id='isc']";
	public static final String MANUFACTURER = "xpath=//select[@id='mid']";
	public static final String ERROR_SEARCH_MESSAGE = "xpath=//div[@class='warning']";
	public static final String SEARCH_MESSAGE = "xpath=//div[@class='no-result']";

	public static final String COMPARE_PRODUCT_NAME = "xpath=//tr[@class='product-name']//a[text()='%s']";
	public static final String COMPARE_PRODUCT_INFO = "xpath=//tr[@class='%s']//td[text()='%s']";
	public static final String REMOVE_BUTTON = "class=remove-button";
}

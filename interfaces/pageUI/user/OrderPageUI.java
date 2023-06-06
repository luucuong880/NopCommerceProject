package pageUI.user;

public class OrderPageUI {
	public static final String DETAILS_BUTTON = "xpath=//button[text()='Details']";
	public static final String DETAILS_BUTTON_BY_TEXT = "xpath=//span[text()='%s']/ancestor::ul/following-sibling::div/button";
	public static final String ORDER_OVERVIEW = "xpath=//li[@class='%s']";
	public static final String BILLING_SHIPPING_ADDRESS = "xpath=//div[@class='%s']//li[@class='%s']";
	public static final String TOTALS_INFO = "xpath=//label[text()='%s']/parent::td/following-sibling::td";
	public static final String INFO_BY_DYNAMICS_CLASS = "xpath=//td[@class='%s']";
	public static final String RE_ORDER_BUTTON = "xpath=//div[@class='actions']//button";

}

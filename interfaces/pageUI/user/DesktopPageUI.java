package pageUI.user;

public class DesktopPageUI {

	public static final String VIEW_MOD_BUTTON = "xpath=//a[text()='%s']";
	public static final String DYNAMIC_DROPDOWN = "xpath=//label[contains(text(),'%s')]/parent::dt/following-sibling::dd/select[@id='%s']";
	public static final String CHECKBOX_OR_RADIO_BUTTON = "xpath=//label[contains(text(),'%s')]/parent::dt/following-sibling::dd//label[text()='%s']/preceding-sibling::input";
	public static final String TOTAL_PRICES = "xpath=//div[@class='prices']//span";
}

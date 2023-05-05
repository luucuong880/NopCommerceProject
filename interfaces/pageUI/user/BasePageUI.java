package pageUI.user;

public class BasePageUI {
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_PAGE_TITLE = "xpath=//h1[contains(text(),'%s')]";
	public static final String BUTTON_TEXT = "xpath=//button[text()='%s']";
	public static final String PRODUCT_BY_DYNAMICS_TEXT = "xpath=//a[text()='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_ID = "xpath=//span[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String SUCCESS_MESSAGE = "xpath=//p[@class='content']";
	public static final String MESSAGE_DYNAMIC_BY_CLASS = "xpath=//div[@class='%s']";
	public static final String CLOSE_BUTTON = "xpath=//span[@class='close']";
	public static final String DYNAMIC_PAGE_AT_TOP_MENU_AREA = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String LINK_BY_TEXT = "xpath=//div[@class='item-grid']//a[contains(text(),'%s')]";
	public static final String ADD_TO_CART_BUTTON = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//button[text()='Add to cart']";
	public static final String HEADER_LINKS = "xpath=//a[@class='%s']";
	public static final String TOTAL_INFOS = "xpath=//tr[@class='%s']//span[@class='value-summary']";
	public static final String PAGE_TITLE_MESSAGE = "xpath=//div[@class='page-title']//h1";
	public static final String BILLING_SHIPPING_ADDRESS = "xpath=//div[@class='%s']//ul/li[@class='%s']";
	public static final String PAYMENT_SHIPPING_METHOD = "xpath=//div[@class='%s']//ul/li[@class='%s']//span[@class='value']";
}

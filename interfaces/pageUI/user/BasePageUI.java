package pageUI.user;

public class BasePageUI {
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_PAGE_TITLE = "xpath=//h1[contains(text(),'%s')]";
	public static final String BUTTON_TEXT = "xpath=//a[text()='%s']";
	public static final String PRODUCT_BY_DYNAMICS_TEXT = "xpath=//a[text()='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_ID = "xpath=//span[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String SUCCESS_MESSAGE = "class=content";
	public static final String NO_DATA_MESSAGE = "class=no-data";
	public static final String MESSAGE_DYNAMIC_BY_CLASS = "xpath=//div[@class='%s']";
	public static final String CLOSE_BUTTON = "xpath=//span[@class='close']";
	public static final String DYNAMIC_PAGE_AT_TOP_MENU_AREA = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String HEADER_LINKS = "xpath=//a[@class='%s']";
	public static final String PAGE_TITLE_MESSAGE = "xpath=//div[@class='page-title']//h1";
	public static final String FOOTER_LINKS = "xpath=//a[text()='%s']";
	public static final String PRODUCT_SIZE = "xpath=//h2[@class='product-title']//a";
	public static final String PRODUCT_PRICE = "xpath=//span[@class='price actual-price']";
	public static final String AJAX_LOADING_ICON = "class=ajax-loading-block-window";
}

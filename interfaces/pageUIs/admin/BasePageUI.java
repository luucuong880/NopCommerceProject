package pageUIs.admin;

public class BasePageUI {
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_lINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DESKTOP_LINK = "xpath=//a[text()=' Desktops ']";
	public static final String NOTEBOOKS_LINK = "xpath=//a[text()=' Notebooks ']";
	public static final String SEARCH_LINK = "xpath=//a[@href='/search']";
	public static final String COMPUTERS_LINK = "xpath=//ul[@class='top-menu notmobile']//a[@href='/computers']";
	public static final String CHANGE_PASSWORD_LINK = "xpath=//a[@href='/customer/changepassword']";
	public static final String ADD_REVIEW_LINK = "xpath=//a[text()='Add your review']";
	public static final String WISH_LIST_LINK = "xpath=//span[@class='wishlist-label']";
	public static final String CART_LINK = "xpath=//a[@class='ico-cart']";
	public static final String COMPARE_PRODUCT_LINK = "xpath=//a[text()='Compare products list']";
	public static final String RECNTLY_VIEWED_LINK = "xpath=//a[text()='Recently viewed products']";
	public static final String LOGOUT_LINK_AT_USER = "class=ico-logout";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String REGISTER_LINK = "class=ico-register";
	public static final String CUSTOMER_BUTTON = "xpath=//p[contains(text(),'Customers')]//i";
	public static final String CUSTOMER_LINK = "xpath=//p[text()=' Customers']";
	public static final String ITEM_IN_TREEVIEW_MENU = "xpath=//i[@class='%s']";
	public static final String ITEM_IN_TREEVIEW = "xpath=//i[@class='%s']/parent::a/following-sibling::ul//p[contains(text(),'%s')]";
	public static final String BUTTON_AT_COLUMN_MENU = "xpath=//i[@class='%s']";
	public static final String ADD_NEW_BUTTON = "xpath=//a[@class='btn btn-primary']";
	public static final String FIELD_INPUT_BY_ID = "xpath=//input[@id='%s']";
	public static final String CLOSE_ICON = "xpath=//span[@class='k-icon k-i-close']";
	public static final String FIELD_INPUT_BY_CLASS = "xpath=//ul[@id='%s']/following-sibling::input";
	public static final String DYNAMIC_NAME_BUTTON = "xpath=//button[@name='%s']";
	public static final String SUCCESS_MESSAGE = "xpath=//div[@class='alert alert-success alert-dismissable']";

}

package pageUI.user;

public class SubMenuPageUI {
	public static final String PAGE_BUTTON = "xpath=//li[@class='%s']";
	public static final String APPLE_WISH_LIST_BUTTON = "xpath=//a[text()='Apple MacBook Pro 13-inch']/parent::h2/following-sibling::div[@class='add-info']//button[@class='button-2 add-to-wishlist-button']";
	public static final String ADD_WISH_LIST_SUCCESS_MESSAGE = "class=content";
	public static final String CLOSE_SUCCESS_MESSAGE = "class=close";
	public static final String APPLE_PRODUCT = "xpath=//h2[@class='product-title']//a[text()='Apple MacBook Pro 13-inch']";
	public static final String ASUS_PRODUCT = "xpath=//h2[@class='product-title']//a[text()='Asus N551JK-XO076H Laptop']";
	public static final String HP_ENVY_PRODUCT = "xpath=//h2[@class='product-title']//a[text()='HP Envy 6-1180ca 15.6-Inch Sleekbook']";
	public static final String HP_SPECTRE_PRODUCT = "xpath=//h2[@class='product-title']//a[text()='HP Spectre XT Pro UltraBook']";
	public static final String SAMSUNG_PRODUCT = "xpath=//h2[@class='product-title']//a[text()='Samsung Series 9 NP900X4C Premium Ultrabook']";
	public static final String WISH_LIST_BUTTON = "id=add-to-wishlist-button-4";
	public static final String QUANTITY_TEXTBOX = "xpath=//input[@class='qty-input valid']";
	public static final String ADD_TO_CART_BUTTON = "xpath=//div[@class='add-to-cart-panel']//button";
	public static final String ADD_CART_SUCCESS_MESSAGE = "class=content";
	public static final String VIEW_MOD_BUTTON = "xpath=//a[text()='%s']";
	public static final String CHECKBOX_OR_RADIO_BUTTON = "xpath=//label[contains(text(),'%s')]/parent::dt/following-sibling::dd//label[text()='%s']/preceding-sibling::input";
	public static final String TOTAL_PRICES = "xpath=//div[@class='prices']//span";
	public static final String REVIEW_LINK = "xpath=//a[text()='Add your review']";
}

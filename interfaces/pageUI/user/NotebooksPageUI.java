package pageUI.user;

public class NotebooksPageUI {
	public static final String SORT_BY = "id=products-orderby";
	public static final String SORT_BY_A_Z = "xpath=//select[@id='products-orderby']//option[text()='Name: A to Z']";
	public static final String SORT_BY_Z_A = "xpath=//select[@id='products-orderby']//option[text()='Name: Z to A']";
	public static final String SORT_BY_H_L = "xpath=//select[@id='products-orderby']//option[text()='Price: High to Low']";
	public static final String SORT_BY_L_H = "xpath=//select[@id='products-orderby']//option[text()='Price: Low to High']";
	public static final String PAGE_SIZE = "id=products-pagesize";
	public static final String PAGE_SIZE_3 = "xpath=//select[@id='products-pagesize']//option[text()='3']";
	public static final String PAGE_SIZE_6 = "xpath=//select[@id='products-pagesize']//option[text()='6']";
	public static final String PAGE_SIZE_9 = "xpath=//select[@id='products-pagesize']//option[text()='9']";
	public static final String NEXT_PAGE_ICON = "class=next-page";
	public static final String NEXT_PAGE_BUTTON = "xpath=//li[@class='next-page']//a";
	public static final String PREVIOUS_PAGE_ICON = "class=previous-page";
	public static final String PREVIOUS_PAGE_BUTTON = "xpath=//li[@class='previous-page']//a";
	public static final String PRODUCT_SIZE = "xpath=//h2[@class='product-title']//a";
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

}
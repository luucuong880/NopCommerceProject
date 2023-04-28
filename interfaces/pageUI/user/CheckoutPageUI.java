package pageUI.user;

public class CheckoutPageUI {

	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String CONFIRM_BUTTON_BY_ID = "xpath=//div[@id='%s']//button[text()='Continue']";
	public static final String SHIP_TO_SAME_ADDRESS = "xpath=//input[@id='ShipToSameAddress']";
	public static final String SKU_NUMBER = "xpath=//span[@class='sku-number']";
	public static final String PRODUCT_NAME = "xpath=//a[@class='product-name']";
	public static final String PRICE = "xpath=//span[@class='product-unit-price']";
	public static final String QUANTITY = "xpath=//span[@class='product-quantity']";
	public static final String PRODUCT_TOTAL = "xpath=//span[@class='product-subtotal']";
	public static final String GIFT_WRAPPING = "xpath=//div[@class='selected-checkout-attributes']";
	public static final String SUB_TOTAL = "xpath=//tr[@class='order-subtotal']//span[@class='value-summary']";
	public static final String SHIPPING_COST = "xpath=//tr[@class='shipping-cost']//span[@class='value-summary']";
	public static final String TAX_VALUE = "xpath=//tr[@class='tax-value']//span[@class='value-summary']";
	public static final String ORDER_TOTAL = "xpath=//tr[@class='order-total']//span[@class='value-summary']";
	public static final String THANK_YOU_MESSAGE = "xpath=//div[@class='page-title']//h1";
	public static final String ORDER_SUCCESS_MESSAGE = "xpath=//strong[text()='Your order has been successfully processed!']";
	public static final String OREDER_LINK = "xpath=//div[@class='details-link']//a";
	public static final String CREDIT_CART_BOX = "xpath=//input[@id='paymentmethod_1']";
	public static final String CREDIT_CART = "xpath=//select[@id='CreditCardType']";
	public static final String CREDIT_CART_DROPDOWN = "xpath=//select[@id='CreditCardType']//option[text()='Visa']";
	public static final String CART_NAME_TEXTOBX = "xpath=//input[@id='CardholderName']";
	public static final String CART_NUMBER_TEXTOBX = "xpath=//input[@id='CardNumber']";
	public static final String EXPIRE_MONTH = "xpath=//select[@id='ExpireMonth']";
	public static final String EXPIRE_YEAR = "xpath=//select[@id='ExpireYear']";
	public static final String CART_CODE_TEXTBOX = "xpath=//input[@id='CardCode']";
	public static final String NEW_ADDRESS = "xpath=//select[@id='billing-address-select']";
	public static final String NEXTDAY_AIR = "xpath=//input[@id='shippingoption_1']";
	public static final String MESSAGE_SIZE = "xpath=//td/p";
	public static final String BILLING_INFO = "xpath=//strong[text()='%s']/parent::div/following-sibling::ul/li[@class='%s']";
	public static final String TITLE_SUCCESS_MESSAGE = "xpath=//div[@class='section order-completed']/div[@class='title']/strong";

}
